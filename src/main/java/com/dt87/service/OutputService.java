package com.dt87.service;

import com.dt87.entity.Output;

import java.util.Date;
import java.util.List;

public interface OutputService {
    //查询退货记录
    public List<Output> findOutput(Output output);
    //查询退货记录
    public List<Output> findAllOutput(Output output, Date startTime, Date endTime);
    //进货 点击退货后更新退货数据
    public int addOutput(Output output);
}
