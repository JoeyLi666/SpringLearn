package cn.lsc.spring_mybatis.demo.mapper;

import cn.lsc.spring_mybatis.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends CommonMapper<User> {
}
