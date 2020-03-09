package com.dt87.controller;

import com.dt87.entity.JsonData;
import com.dt87.entity.Provider;
import com.dt87.service.impl.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/provider")
public class ProviderController {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-03-01 15:37
     **/
    @Autowired
    private ProviderServiceImpl providerService;
    //查询所有供应商
    @RequestMapping("/findAllProvider")
    @ResponseBody
    public JsonData findAllProvider(Provider provider) {
        return JsonData.buildSuccess(providerService.findAllProvider(provider),-1);
    }
}
