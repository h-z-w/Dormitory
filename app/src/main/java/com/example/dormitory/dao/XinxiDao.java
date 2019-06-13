package com.example.dormitory.dao;

import com.example.dormitory.model.Xinxi;

import java.util.List;

public interface XinxiDao {
    //查询
    List<Xinxi> selectAllXinxi();
    //条件查询
//    Xinxi select(String name);
//    List<Xinxi> selectByCost(int cost);
//添加
    void insert(Xinxi xinxi);
    void update(Xinxi xinxi);
    void delete(String name);
}
