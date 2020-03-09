package com.dt87.service.impl;

import com.dt87.entity.Customer;
import com.dt87.mapper.CustomerMapper;
import com.dt87.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-29 17:13
     **/
    //查询所有顾客
    @Resource
    private CustomerMapper customerMapper;
    public List<Customer> findAllCustomer(Customer customer) {
        return customerMapper.findAllCustomer(customer);
    }

    //修改顾客信息
    @Transactional
    public int updateCustomer(Customer customer) {
        return customerMapper.updateCustomer(customer);
    }

    //添加客户
    @Transactional
    public int addCustomer(Customer customer) {
        return customerMapper.addCustomer(customer);
    }

    //删除客户
    @Transactional
    public int deleteCustomer(Customer customer) {
        return customerMapper.deleteCustomer(customer);
    }

    //批量删除客户
    public int deleteSelectCustomer(List<Integer> ids) {
        return customerMapper.deleteSelectCustomer(ids);
    }


}
