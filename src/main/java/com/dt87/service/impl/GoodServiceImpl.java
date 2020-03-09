package com.dt87.service.impl;

import com.dt87.entity.Good;
import com.dt87.mapper.GoodMapper;
import com.dt87.service.GoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
@Service
public class GoodServiceImpl implements GoodService {

    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-03-01 15:25
     **/
    @Resource
    private GoodMapper goodMapper;
   //查询所有商品
    public List<Good> findAllGood(Good good) {
        return goodMapper.findAllGood(good);
    }

    //查询所有商品 进货管理用根 据供应商id 查询对应所有商品名称
    public List<Good> findAllGoodInput(Good good) {
        return goodMapper.findAllGoodInput(good);
    }

    //更新商品信息
    public int updateGood(Good good) {
        return goodMapper.updateGood(good);
    }

    //添加商品信息
    public int addGood(Good good) {
        return goodMapper.addGood(good);
    }

   //删除商品信息
    public int deleteGood(Good good) {
        return goodMapper.deleteGood(good);
    }

    //批量删除商品信息
    public int deleteSelectGood(List<Serializable> list) {
        return goodMapper.deleteSelectGood(list);
    }

    //查询所有商品 进货管理用 根据商品id查询商品名称
    /*public Good findAllGoodInputById(Integer id) {
        return goodMapper.findAllGoodInputById(id);
    }*/

}
