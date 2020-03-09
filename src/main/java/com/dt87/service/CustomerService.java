package com.dt87.service;

import com.dt87.entity.Customer;

import java.util.List;

public interface CustomerService {
    //查询所有顾客
    public List<Customer> findAllCustomer(Customer customer);
    //修改顾客信息
    public int updateCustomer(Customer customer);
    //添加客户
    public int addCustomer(Customer customer);
    //删除客户
    public int deleteCustomer(Customer customer);
    //批量删除客户  其实可以单个循环删除
    public int deleteSelectCustomer(List<Integer> ids);
}
