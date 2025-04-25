package com.coder.dao;

import com.coder.entity.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    List<GoodsType> selectList();
    boolean save(GoodsType goodsType);
    boolean delete(Integer id);
    boolean update(GoodsType goodsType);
    GoodsType selectById(Integer id);
    boolean deleteChecked(String[] ids);
}