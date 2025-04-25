package com.coder.service;

import com.coder.entity.RoomType;

import java.util.List;

public interface RoomTypeService {
    List<RoomType> list();
    boolean insert(RoomType roomType);
    boolean remove(Integer id);
    boolean update(RoomType roomType);
    RoomType getById(Integer id);
    boolean deleteChecked(String [] ids);
}
