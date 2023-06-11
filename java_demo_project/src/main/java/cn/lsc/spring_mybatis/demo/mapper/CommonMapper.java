package cn.lsc.spring_mybatis.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface CommonMapper <T> extends BaseMapper<T> {

    int insertBatchSomeColumn(List<T> entityList);
}
