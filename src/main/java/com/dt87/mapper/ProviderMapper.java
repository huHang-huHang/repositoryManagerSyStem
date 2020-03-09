package com.dt87.mapper;

import com.dt87.entity.Provider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ProviderMapper {
    //查询所有供应商  商品界面用的
    public List<Provider> findAllProvider(@Param("provider") Provider provider);


}
