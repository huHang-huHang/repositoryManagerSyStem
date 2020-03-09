package com.dt87.controller;

import com.dt87.entity.*;
import com.dt87.service.impl.GoodServiceImpl;
import com.dt87.service.impl.InputServiceImpl;
import com.dt87.service.impl.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/input")
public class InputController {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-03-02 10:13
     **/
    @Autowired
    private InputServiceImpl inputService;
    @Autowired
     private ProviderServiceImpl providerService;
    @Autowired
     private GoodServiceImpl goodService;
    //查询所有进货
    @RequestMapping("/findAllInput")
    @ResponseBody
    public JsonData findAllInput(Input input, String  startTime,String endTime) throws ParseException {
        //System.out.println(startTime);
        //System.out.println(endTime);
        //System.out.println(input+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Date startTime1 = null;
        Date endTime1 = null;
        if (startTime != null && startTime != "") {
            startTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
        }
        if (endTime != null && endTime != "") {
            endTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
        }
        return JsonData.buildSuccess(inputService.findAllInput(input,startTime1,endTime1),0);
    }
    //添加进货
    @RequestMapping("/addInput")
    @ResponseBody
    public JsonData addInput(Input input,HttpSession session){
        User user = (User)session.getAttribute("user");
        input.setOperateperson(user.getName());
        input.setInporttime(new Date());
        System.out.println(input+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        try {
            int count = inputService.addInput(input);
            if (count>0){
                return JsonData.buildSuccess(null,"添加成功");
            }else {
                return JsonData.buildError("添加失败",-1);
            }
        }catch (Exception e){
            return JsonData.buildError("添加失败",-1);
        }
    }
    //修改进货
    @RequestMapping("/updateInput")
    @ResponseBody
    public JsonData updateInput(Input input, HttpSession session){
        User user = (User)session.getAttribute("user");
        input.setOperateperson(user.getName());
        input.setInporttime(new Date());

        try {
            int count = inputService.updateInput(input);
            if (count>0){
                return JsonData.buildSuccess(null,"修改成功");
            }else {
                return JsonData.buildError("修改失败",-1);
            }
        }catch (Exception e){
            return JsonData.buildError("修改失败",-1);
        }
    }
    //删除进货
    @RequestMapping("/deleteInput")
    @ResponseBody
    public JsonData deleteInput(Input input){

        try {
            int count = inputService.deleteInput(input);
            if (count>0){
                return JsonData.buildSuccess(null,"删除成功");
            }else {
                return JsonData.buildError("删除失败",-1);
            }
        }catch (Exception e){
            return JsonData.buildError("删除失败",-1);
        }
    }
}
