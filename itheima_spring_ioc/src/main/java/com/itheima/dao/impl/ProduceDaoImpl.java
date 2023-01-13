package com.itheima.dao.impl;

import com.itheima.dao.ProduceDao;

public class ProduceDaoImpl implements ProduceDao {

    private Long produceId;

    public ProduceDaoImpl() {
    }

    public ProduceDaoImpl(Long produceId) {
        this.produceId = produceId;
    }

    @Override
    public void save() {
        System.out.println("ProduceDaoImpl has run.");
    }
}
