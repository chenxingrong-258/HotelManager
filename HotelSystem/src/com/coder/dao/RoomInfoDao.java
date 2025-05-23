package com.coder.dao;

import com.coder.entity.RoomInfo;

import java.util.List;

public interface RoomInfoDao {
    List<RoomInfo> selectList();
    boolean save(RoomInfo roomInfo);
    boolean delete(Integer id);
    boolean update(RoomInfo roomInfo);
    RoomInfo selectById(Integer id);
    boolean deleteChecked(String[] ids);
}

