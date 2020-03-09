package com.dt87.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/business")
public class BusinessController {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-29 17:31
     **/
    //去顾客管理
    @RequestMapping("/toCustomerManager")
    public String toCustomer() {
      return "business/customer/customerManager";
    }
    //去商品管理
    @RequestMapping("/toGoodsManager")
    public String toGood(){
        return "business/good/goodsManager";
    }
    //去商品进货管理
    @RequestMapping("/toInportManager")
    public String toInput(){
        return "business/input/inportManager";
    }
   //去商品退货管理
   @RequestMapping("/toOutportManager")
   public String toOutput(){
       return "business/output/outportManager";
   }
}
