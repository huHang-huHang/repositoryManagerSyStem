package com.dt87.mapper;

import com.dt87.entity.Input;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface InputMapper {
    //查询所有进货
    public List<Input> findAllInput(@Param("input") Input input, @Param("startTime")Date startTime,@Param("endTime") Date endTime);
    //更新进货
    public int updateInput(@Param("input") Input input);
    //添加进货
    public int addInput(@Param("input") Input input);
    //删除进货
    public int deleteInput(@Param("input") Input input);
    //查询进货信息 退货管理用
    public Input findInput(@Param("inportid") Integer inportid);
}
