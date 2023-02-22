package cn.lsc.springboot_mybatis_plus.mapper;

import cn.lsc.springboot_mybatis_plus.dao.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
