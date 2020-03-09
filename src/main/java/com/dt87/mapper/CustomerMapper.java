package com.dt87.mapper;

import com.dt87.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CustomerMapper {
    //查询所有顾客
    public List<Customer> findAllCustomer(@Param("customer") Customer customer);
    //修改顾客信息
    public int updateCustomer(@Param("customer") Customer customer);
    //添加客户
    public int addCustomer(@Param("customer") Customer customer);
    //删除客户
    public int deleteCustomer(@Param("customer") Customer customer);
    //批量删除客户  其实可以单个循环删除
    public int deleteSelectCustomer(@Param("ids") List<Integer> ids);
}
