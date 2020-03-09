package com.dt87.service;

import com.dt87.entity.Input;

import java.util.Date;
import java.util.List;

public interface InputService {
    //查询所有进货
    public List<Input> findAllInput(Input input, Date startTime, Date endTime);
    //更新进货
    public int updateInput(Input input);
    //添加进货
    public int addInput(Input input);
    //删除进货
    public int deleteInput(Input input);
    //查询进货信息 退货管理用
    public Input findInput(Integer inportid);
}
