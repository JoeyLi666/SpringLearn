package cn.lsc.spring_mybatis.demo.mapper;

import cn.lsc.spring_mybatis.demo.pojo.User;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.test.autoconfigure.MybatisPlusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@MybatisPlusTest
public class UserMapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assertions.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testFindUsersByPage() {
        int size = 1;
        Page<User> userPage = new Page<>(1, size);
        Page<User> userPage1 = userMapper.selectPage(userPage, null);
        List<User> records = userPage1.getRecords();
        for (User record : records) {
            System.out.println(record.toString());
        }
    }
}
