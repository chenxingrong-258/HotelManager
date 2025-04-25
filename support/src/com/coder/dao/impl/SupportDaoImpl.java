package com.coder.dao.impl;

import com.coder.dao.SupportDao;
import com.coder.entity.Support;
import com.coder.util.DBUtil;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class SupportDaoImpl implements SupportDao {
    @Override
    public Support selectByEmail(String email) {
        String sql = "select * from support where email = ?";
        try {
            return DBUtil.getQueryRunner().query(sql,new BeanHandler<Support>(Support.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean reg(Support support) {
        String sql = "insert into suport values(?,?)";
        String name = support.getName();
        String email = support.getEmail();
        try {
            return DBUtil.getQueryRunner().update(sql,name,email)>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
