package com.itheima.test;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.ProduceDaoImpl;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    //测试scope属性
    public void testUserDaoImpl() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        //app.close();
    }

    @Test
    //测试scope属性
    public void testProduceDaoImpl() {
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProduceDaoImpl produceDao = (ProduceDaoImpl) app.getBean("produceDao");
        produceDao.save();
        //app.close();
    }

}
