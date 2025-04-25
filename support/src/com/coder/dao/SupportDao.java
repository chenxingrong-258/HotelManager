package com.coder.dao;

import com.coder.entity.Support;

public interface SupportDao {
    Support selectByEmail(String email);
    boolean reg(Support support);
}
