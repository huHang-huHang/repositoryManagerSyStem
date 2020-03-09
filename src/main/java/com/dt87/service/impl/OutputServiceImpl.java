package com.dt87.service.impl;

import com.dt87.entity.Output;
import com.dt87.mapper.OutputMapper;
import com.dt87.service.OutputService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class OutputServiceImpl implements OutputService {
    //查询退货记录 删除进货记录用
    @Resource
    private OutputMapper outputMapper;
    public List<Output> findOutput(Output output) {
        return outputMapper.findOutput(output);
    }

    //查询退货记录
    public List<Output> findAllOutput(Output output, Date startTime, Date endTime) {
        return outputMapper.findAllOutput(output,startTime,endTime);
    }

    //进货 点击退货后更新退货数据
    public int addOutput(Output output) {
        return outputMapper.addOutput(output);
    }

}
