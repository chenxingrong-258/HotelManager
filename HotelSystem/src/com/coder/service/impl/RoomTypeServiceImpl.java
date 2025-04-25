package com.coder.service.impl;

import com.coder.dao.RoomTypeDao;
import com.coder.dao.impl.RoomTypeDaoImpl;
import com.coder.entity.RoomType;
import com.coder.service.RoomTypeService;

import java.util.List;

public class RoomTypeServiceImpl implements RoomTypeService {
    private RoomTypeDao dao;
    public RoomTypeServiceImpl() {
        this.dao = new RoomTypeDaoImpl();
    }
    @Override
    public List<RoomType> list() {
        return dao.selectList();
    }

    @Override
    public boolean insert(RoomType roomType) {
        return dao.save(roomType);
    }

    @Override
    public boolean remove(Integer id) {
        return dao.delete(id);
    }

    @Override
    public boolean update(RoomType roomType) {
        return dao.update(roomType);
    }

    @Override
    public RoomType getById(Integer id) {
        return dao.selectById(id);
    }

    @Override
    public boolean deleteChecked(String[] ids) {
        return dao.deleteCheck(ids);
    }
}
