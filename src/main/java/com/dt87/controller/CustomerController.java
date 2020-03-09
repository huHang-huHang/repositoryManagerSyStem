package com.dt87.controller;

import com.dt87.entity.Customer;
import com.dt87.entity.JsonData;
import com.dt87.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-29 17:24
     **/
    @Autowired
    private CustomerServiceImpl customerService;

    //查询顾客
    @RequestMapping("/findAllCustomer")
    @ResponseBody
    public JsonData findAllCustomer(Customer customer) {
        return JsonData.buildSuccess(customerService.findAllCustomer(customer), 0);
    }

    //修改客户
    @RequestMapping("/updateCustomer")
    @ResponseBody
    public JsonData updateCustomer(Customer customer) {
        try {
            int i = customerService.updateCustomer(customer);
            if (i > 0) {
                return JsonData.buildSuccess(null, customer.getCustomername() + "的信息修改成功");
            } else {
                return JsonData.buildError("修改失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("修改失败,有信息为空", -1);
        }
    }

    //添加客户
    @RequestMapping("/addCustomer")
    @ResponseBody
    public JsonData addCustomer(Customer customer) {
        try {
            customerService.addCustomer(customer);
            return JsonData.buildSuccess(null, "添加成功");
        } catch (Exception e) {
            return JsonData.buildError("添加失败", -1);
        }
    }

    //删除客户
    @RequestMapping("/deleteCustomer")
    @ResponseBody
    public JsonData delete(Customer customer) {
        try {
            int count = customerService.deleteCustomer(customer);
            if (count > 0) {
                return JsonData.buildSuccess(null, "删除成功");
            } else {
                return JsonData.buildError("删除失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("删除失败", -1);
        }

    }

    //批量删除
    @RequestMapping("/deleteSelectCustomer")
    @ResponseBody
    public JsonData deleteSelectCustomer(Integer ids[]) {
        List<Integer> idList = new ArrayList<Integer>();
        for (Integer id : ids) {
            idList.add(id);
        }
        try {
            int count = customerService.deleteSelectCustomer(idList);
            if(count>0){
                return  JsonData.buildSuccess(null,"批量删除成功");
            }else {
                return JsonData.buildError("批量删除失败",-1);
            }
        }catch (Exception e){
              return JsonData.buildError("批量删除失败",-1);
        }
    }
}
