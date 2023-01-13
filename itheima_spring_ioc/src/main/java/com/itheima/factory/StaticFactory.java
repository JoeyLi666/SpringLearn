package com.itheima.factory;

import com.itheima.dao.ProduceDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.ProduceDaoImpl;
import com.itheima.dao.impl.UserDaoImpl;

public class StaticFactory {

    public static UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public static ProduceDao getProduceDao() {
        System.out.println("靜態方法又被調用");
        return new ProduceDaoImpl();
    }

}
