package com.coder.service;

import com.coder.dao.SupportDao;
import com.coder.entity.Support;

public interface SupportService {
    Support selectEmail(String email);
    boolean insert(Support support);
}
