package com.itheima.service.impl;

import com.itheima.dao.ProduceDao;
import com.itheima.service.ProduceService;

public class ProduceServiceImpl implements ProduceService {

    private ProduceDao produceDao;

    public ProduceServiceImpl(ProduceDao produceDao) {
        this.produceDao = produceDao;
    }

    public void setProduceDao(ProduceDao produceDaos) {
        System.out.println("通過set方法進行注入");
        this.produceDao = produceDaos;
        System.out.println("set処"+produceDaos.hashCode());
    }

    @Override
    public void save() {
        produceDao.save();
        System.out.println(produceDao.hashCode());
    }
}
