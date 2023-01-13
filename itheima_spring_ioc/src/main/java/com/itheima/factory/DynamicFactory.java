package com.itheima.factory;

import com.itheima.dao.ProduceDao;
import com.itheima.dao.UserDao;
import com.itheima.dao.impl.ProduceDaoImpl;
import com.itheima.dao.impl.UserDaoImpl;

public class DynamicFactory {

    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    public ProduceDao getProduceDao() {
        System.out.println("非靜態方法又被調用");
        return new ProduceDaoImpl();
    }

}
