package com.coder.service;

import com.coder.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    List<GoodsType> list();
    boolean insert(GoodsType goodsType);
    boolean remove(Integer id);
    boolean update(GoodsType goodsType);
    GoodsType getById(Integer id);
    boolean removeChecked(String[] ids);
}