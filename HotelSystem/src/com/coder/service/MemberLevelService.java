package com.coder.service;

import com.coder.entity.MemberLevel;

import java.util.List;

public interface MemberLevelService {
    List<MemberLevel> list();
    boolean insert(MemberLevel memberLevel);
    boolean remove(Integer id);
    boolean update(MemberLevel memberLevel);
    MemberLevel getById(Integer id);
    boolean removeChecked(String[] ids);
}
