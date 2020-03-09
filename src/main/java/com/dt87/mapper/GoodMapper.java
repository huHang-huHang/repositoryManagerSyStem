package com.dt87.mapper;

import com.dt87.entity.Good;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.List;
@Mapper
public interface GoodMapper {
    //查询所有商品
    public List<Good> findAllGood(@Param("good") Good good);
    //查询所有商品 进货管理用 供应商id查询商品
    public List<Good> findAllGoodInput(@Param("good") Good good);
    //查询所有商品 进货管理用 根据商品id查询商品名称
    //public Good findAllGoodInputById(@Param("id") Integer id);
    //更新商品信息
    public int updateGood(@Param("good") Good good);
    //添加商品信息
    public int addGood(@Param("good") Good good);
    //删除商品信息
    public int deleteGood(@Param("good") Good good);
    //删除商品信息 批量删除
    public int deleteSelectGood(@Param("list") List<Serializable> list);

}
