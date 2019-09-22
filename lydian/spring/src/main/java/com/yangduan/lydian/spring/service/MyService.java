package com.yangduan.lydian.spring.service;

import com.yangduan.lydian.spring.dao.MyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class MyService {
    private final MyDao dao;

    @Autowired
    public MyService(MyDao dao) {
        this.dao = dao;
    }

    public Map<String, Object> getNewsById(long id) {
        return dao.getNewsById(id);
    }
}
