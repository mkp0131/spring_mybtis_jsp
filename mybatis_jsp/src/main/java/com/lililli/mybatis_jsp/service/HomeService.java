package com.lililli.mybatis_jsp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lililli.mybatis_jsp.dao.HomeDao;

@Service
public class HomeService {

    @Autowired
    HomeDao homeDao;

    public List<HomeVO> getHomeList() {
        return homeDao.getHomeList();
    }

}
