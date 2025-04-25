package com.coder.service;

import com.coder.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> list();
    boolean insert(Admin admin);
    Admin login(Admin admin);
    boolean updateLogin(Admin admin);
    boolean update(Admin admin);
    boolean delete(Integer id);
    boolean deleteChecked(String []ids);
    Admin getById(Integer id);
}
