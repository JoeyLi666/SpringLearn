package cn.lsc.springboot_mybatis_plus.extension.impl;

import cn.lsc.springboot_mybatis_plus.dao.ClubPo;
import cn.lsc.springboot_mybatis_plus.extension.ClubPoService;
import cn.lsc.springboot_mybatis_plus.mapper.ClubMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.enums.SqlMethod;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Map;

public class ClubPoServiceImpl extends ServiceImpl<ClubMapper, ClubPo> implements ClubPoService {
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdateBatchByColumn(Collection<?> entityList, String idCard) {

        return SqlHelper.saveOrUpdateBatch(this.entityClass, this.mapperClass, super.log, entityList, DEFAULT_BATCH_SIZE, (sqlSession, entity) -> {
            LambdaQueryWrapper<ClubPo> queryWrapper = Wrappers.<ClubPo>lambdaQuery()
                    .eq(ClubPo::getName, idCard);
            Map<String, Object> map = CollectionUtils.newHashMapWithExpectedSize(1);
            map.put(Constants.WRAPPER, queryWrapper);
            return CollectionUtils.isEmpty(sqlSession.selectList(getSqlStatement(SqlMethod.SELECT_LIST), map));
        }, (sqlSession, entity) -> {
            Map<String, Object> param = CollectionUtils.newHashMapWithExpectedSize(2);
            param.put(Constants.ENTITY, entity);
            sqlSession.update(getSqlStatement(SqlMethod.UPDATE_BY_ID), param);
        });
    }
}
