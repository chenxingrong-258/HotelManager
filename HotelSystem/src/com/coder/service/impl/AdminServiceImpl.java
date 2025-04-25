package com.coder.service.impl;

import com.coder.dao.AdminDao;
import com.coder.dao.impl.AdminDaoImpl;
import com.coder.entity.Admin;
import com.coder.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDao dao;
    public AdminServiceImpl() {
        dao = new AdminDaoImpl();
    }
    @Override
    public List<Admin> list() {
        return dao.selectList();
    }

    @Override
    public boolean insert(Admin admin) {
        return dao.save(admin);
    }
    @Override
    public Admin login(Admin admin) {
        return dao.login(admin);
    }

    @Override
    public boolean updateLogin(Admin admin) {
        return dao.updateLastLoginTime(admin);
    }

    @Override
    public boolean update(Admin admin) {
        return dao.update(admin);
    }

    @Override
    public boolean delete(Integer id) {
        return dao.delete(id);
    }

    @Override
    public boolean deleteChecked(String[] ids) {
        return dao.deleteChecked(ids);
    }

    @Override
    public Admin getById(Integer id) {
        return dao.selectById(id);
    }
}
