package com.coder.dao.impl;

import com.coder.dao.RoomTypeDao;
import com.coder.entity.RoomType;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomTypeDaoImpl implements RoomTypeDao {
    @Override
    public List<RoomType> selectList() {
        String sql = "select * from roomtype";
        try {
            return runner.query(sql, new BeanListHandler<RoomType>(RoomType.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean save(RoomType roomType) {
        int i;
        String sql = "insert into roomtype values(default,?,?,?,?,?)";
        try {
            i=runner.update(sql,roomType.getType(),roomType.getPrice(),roomType.getDeposit(),roomType.getBednum(),roomType.getRemark());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (i>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "delete from roomtype where id = ?";
        try {
            int update = runner.update(sql, id);
            if (update>0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean update(RoomType roomType) {
        String sql = "update roomtype set type=?,price=?,deposit=?,bednum=?,remark=? where id = ?";
        try {
            int update = runner.update(sql, roomType.getType(), roomType.getPrice(), roomType.getDeposit(), roomType.getBednum(), roomType.getRemark(),roomType.getId());
            if (update>0){
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public RoomType selectById(Integer id) {
        String sql = "select * from roomtype where id = ?";
        try {
            RoomType roomType = runner.query(sql, new BeanHandler<RoomType>(RoomType.class), id);
            return roomType;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteCheck(String[] ids) {
        String sql = "delete from roomtype where id = ?";
        List<Object> list = new ArrayList<>();
        for (String id : ids) {
            list.add(new Object[]{id});
        }
        try {
            runner.batch(sql,list.toArray(new Object[list.size()][]));
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
