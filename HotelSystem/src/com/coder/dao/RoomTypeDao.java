package com.coder.dao;

import com.coder.entity.RoomType;
import com.coder.util.DBUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.util.List;

public interface RoomTypeDao {
    QueryRunner runner = new QueryRunner(DBUtil.getDataSource());
    List<RoomType> selectList();
    boolean save(RoomType roomType);
    boolean delete(Integer id);
    boolean update(RoomType roomType);
    RoomType selectById(Integer id);
    boolean deleteCheck(String [] ids);
}
