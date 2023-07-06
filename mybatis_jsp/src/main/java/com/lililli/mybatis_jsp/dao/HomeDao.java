package com.lililli.mybatis_jsp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lililli.mybatis_jsp.service.HomeVO;

@Mapper
public interface HomeDao {
    public List<HomeVO> getHomeList();
}
