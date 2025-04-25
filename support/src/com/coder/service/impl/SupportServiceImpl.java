package com.coder.service.impl;

import com.coder.dao.SupportDao;
import com.coder.dao.impl.SupportDaoImpl;
import com.coder.entity.Support;
import com.coder.service.SupportService;

public class SupportServiceImpl implements SupportService {
    private final SupportDao dao;
    public SupportServiceImpl() {
        dao = new SupportDaoImpl();
    }
    @Override
    public Support selectEmail(String email) {
        return dao.selectByEmail(email);
    }

    @Override
    public boolean insert(Support support) {
        return dao.reg(support);
    }
}
