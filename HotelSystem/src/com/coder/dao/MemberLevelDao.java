package com.coder.dao;

import com.coder.entity.MemberLevel;

import java.util.List;

public interface MemberLevelDao {
    List<MemberLevel> selectList();
    boolean save(MemberLevel memberLevel);
    boolean delete(Integer id);
    boolean update(MemberLevel memberLevel);
    MemberLevel selectById(Integer id);
    boolean deleteChecked(String[] ids);
}