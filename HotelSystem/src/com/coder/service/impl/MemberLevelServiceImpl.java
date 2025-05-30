package com.coder.service.impl;

import com.coder.dao.MemberLevelDao;
import com.coder.dao.impl.MemberLevelDaoImpl;
import com.coder.entity.MemberLevel;
import com.coder.service.MemberLevelService;

import java.util.List;

public class MemberLevelServiceImpl implements MemberLevelService {
    private final MemberLevelDao dao;

    public MemberLevelServiceImpl() {
        dao=new MemberLevelDaoImpl();
    }

    @Override
    public List<MemberLevel> list() {
        return dao.selectList();
    }

    @Override
    public boolean insert(MemberLevel memberLevel) {
        return dao.save(memberLevel);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(MemberLevel memberLevel) {
        return dao.update(memberLevel);
    }

    @Override
    public MemberLevel getById(Integer id) {
        return dao.selectById(id);
    }

    @Override
    public boolean removeChecked(String[] ids) {
        return dao.deleteChecked(ids);
    }
}

