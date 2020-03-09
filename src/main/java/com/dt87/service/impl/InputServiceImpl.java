package com.dt87.service.impl;

import com.dt87.entity.Input;
import com.dt87.mapper.InputMapper;
import com.dt87.service.InputService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class InputServiceImpl implements InputService {

    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-03-02 10:07
     **/
    @Resource
    private InputMapper inputMapper;

    //查询所有进货
    public List<Input> findAllInput(Input input, Date startTime, Date endTime) {
        return inputMapper.findAllInput(input,startTime,endTime);
    }

   //修改进货
    public int updateInput(Input input) {
        return inputMapper.updateInput(input);
    }

   //添加进货
    public int addInput(Input input) {
        return inputMapper.addInput(input);
    }

   //删除进货
    public int deleteInput(Input input) {
        return inputMapper.deleteInput(input);
    }

    //查询进货信息 退货管理用
    public Input findInput(Integer inportid) {
        return inputMapper.findInput(inportid);
    }

}
