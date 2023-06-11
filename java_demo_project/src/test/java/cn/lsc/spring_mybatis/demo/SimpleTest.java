package cn.lsc.spring_mybatis.demo;

import cn.lsc.spring_mybatis.demo.mapper.UserMapper;
import cn.lsc.spring_mybatis.demo.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class SimpleTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assertions.assertEquals(6, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("Test");
        user.setEmail("test@test.com");
        user.setAge(18);

        int insert = userMapper.insert(user);
        Assertions.assertEquals(1, insert);

        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assertions.assertEquals(6, userList.size());
        userList.forEach(System.out::println);
    }
    @Test
    public void testSavaOnBatch(){
        List<User> users = new ArrayList<>(5);
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("Test_"+i);
            user.setEmail("test@test.com");
            user.setAge(18);
            users.add(user);
        }
        long l = System.currentTimeMillis();
        userMapper.insertBatchSomeColumn(users);
        long l1 = System.currentTimeMillis();
        System.out.println("-------------------:"+(l1-l));
        users.clear();

        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }


}
