package com.itheima.service;

import com.itheima.dao.ProduceDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProduceServiceImplTest {
    ProduceService produceService;

    @Before
    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        produceService = (ProduceService) applicationContext.getBean("produceService");
        ProduceDao produceDao = (ProduceDao) applicationContext.getBean("produceDao");
        System.out.println("init 処"+produceDao.hashCode());
    }

    @Test
    public void saveTest() {
        produceService.save();
    }
}
