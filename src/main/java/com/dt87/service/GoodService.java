package com.dt87.service;

import com.dt87.entity.Good;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;

public interface GoodService {
    //查询所有商品
    public List<Good> findAllGood(Good good);
    //查询所有商品 进货管理用
    public List<Good> findAllGoodInput(Good good);
    //查询所有商品 进货管理用 根据商品id查询商品名称
    //public Good findAllGoodInputById(@Param("id") Integer id);
    //更新商品信息
    public int updateGood(Good good);
    //添加商品信息
    public int addGood(Good good);
    //删除商品信息
    public int deleteGood(Good good);
    //批量删除商品信息
    public int deleteSelectGood(List<Serializable> list);
}
