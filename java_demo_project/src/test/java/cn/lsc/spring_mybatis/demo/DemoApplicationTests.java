package cn.lsc.spring_mybatis.demo;

import cn.lsc.spring_mybatis.demo.mapper.UserMapper;
import cn.lsc.spring_mybatis.demo.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	UserMapper userMapper;

	@Test
	public void testSelect() {
		System.out.println(("----- selectAll method test ------"));
		List<User> userList = userMapper.selectList(null);
		Assertions.assertEquals(5, userList.size());
		userList.forEach(System.out::println);
	}
}
