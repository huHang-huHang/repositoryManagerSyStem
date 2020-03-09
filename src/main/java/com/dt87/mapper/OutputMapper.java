package com.dt87.mapper;

import com.dt87.entity.Output;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface OutputMapper {
    //查询退货记录  删除进货记录用
    public List<Output> findOutput(@Param("output") Output output);
    //查询退货记录
    public List<Output> findAllOutput(@Param("output") Output output, @Param("startTime") Date startTime,@Param("endTime") Date endTime);
    //进货 点击退货后更新退货数据 不知道进货数据要不要减
    public int addOutput(@Param("output") Output output);
}
