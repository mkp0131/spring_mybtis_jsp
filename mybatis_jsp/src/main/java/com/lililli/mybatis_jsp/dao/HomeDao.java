package com.lililli.mybatis_jsp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeDao {
    public List<Map<String, String>> getHomeList();
}
