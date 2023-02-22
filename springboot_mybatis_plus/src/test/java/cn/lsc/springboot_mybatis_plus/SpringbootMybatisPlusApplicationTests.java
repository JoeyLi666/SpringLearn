package cn.lsc.springboot_mybatis_plus;

import cn.lsc.springboot_mybatis_plus.dao.User;
import cn.lsc.springboot_mybatis_plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class SpringbootMybatisPlusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println("--------selectAll method test-------");
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User();
        user.setName("小李");
        user.setAge(22);
        user.setEmail("111111115@qq.com");
        int insert = userMapper.insert(user);//如果没有设置id，那么会自动生成id
        System.out.println(insert);//受影响行数
        System.out.println(user);//id会自动回填
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(5L);
        user.setName("id:5,修改过后");

        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    void contextLoads() {
    }

}
