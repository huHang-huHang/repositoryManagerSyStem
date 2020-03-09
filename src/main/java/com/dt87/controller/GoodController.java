package com.dt87.controller;

import com.dt87.entity.Good;
import com.dt87.entity.JsonData;
import com.dt87.entity.Provider;
import com.dt87.mapper.ProviderMapper;
import com.dt87.service.impl.GoodServiceImpl;
import com.dt87.service.impl.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

@Controller
@RequestMapping("/good")
public class GoodController {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-03-01 15:37
     **/
    @Autowired
    private GoodServiceImpl goodService;
    @Autowired
    private ProviderServiceImpl providerService;
    //查询所有商品
    @RequestMapping("/findAllGood")
    @ResponseBody
    public JsonData findAllGood(Good good) {
        System.out.println(good);
        return JsonData.buildSuccess(goodService.findAllGood(good),0);
    }
    // 查询商品  为进货管理服务的 根据根据商品中的providerid 查询所有商品名称
    @RequestMapping("/findAllGoodInput")
    @ResponseBody
    public JsonData findAllGoodInput(Good good) {
        return  JsonData.buildSuccess(goodService.findAllGoodInput(good),0);
    }
    //更新商品
    @RequestMapping("/updateGood")
    @ResponseBody
    public JsonData updateGod(Good good){
        try {
            int i = goodService.updateGood(good);
            if (i > 0) {
                return JsonData.buildSuccess(null,  "修改成功");
            } else {
                return JsonData.buildError("修改失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("修改失败,有信息为空", -1);
        }
    }
    //添加商品信息
    @RequestMapping("/addGood")
    @ResponseBody
    public JsonData addGood(Good good){
        try {
            int i = goodService.addGood(good);
            if (i > 0) {
                return JsonData.buildSuccess(null, "添加成功");
            } else {
                return JsonData.buildError("添加失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("添加失败", -1);
        }
    }
    //删除商品信息
    @RequestMapping("/deleteGood")
    @ResponseBody
    public JsonData deleteGood(Good good){
        try {
            int i = goodService.deleteGood(good);
            if (i > 0) {
                return JsonData.buildSuccess(null, "删除成功");
            } else {
                return JsonData.buildError("删除失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("删除失败", -1);
        }
    }
    //删除商品信息
    @RequestMapping("/deleteSelectGood")
    @ResponseBody
    public JsonData deleteSelectGood(int[] ids){
        ArrayList<Serializable> idList = new ArrayList<Serializable>();
        for (Integer id:ids) {
            idList.add(id);
        }
        System.out.println(idList);
        try {
            int i = goodService.deleteSelectGood(idList);
            if (i > 0) {
                return JsonData.buildSuccess(null, "批量删除成功");
            } else {
                return JsonData.buildError("批量删除失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("批量删除失败了", -1);
        }
    }
}
