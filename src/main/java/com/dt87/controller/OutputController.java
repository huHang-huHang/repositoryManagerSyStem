package com.dt87.controller;

import com.dt87.entity.Input;
import com.dt87.entity.JsonData;
import com.dt87.entity.Output;
import com.dt87.entity.User;
import com.dt87.service.impl.InputServiceImpl;
import com.dt87.service.impl.OutputServiceImpl;
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
@RequestMapping("/output")
public class OutputController {
    //查询退货  进货页面删除进货用
    @Autowired
    private OutputServiceImpl outputService;
    @Autowired
    private InputServiceImpl inputService;
    @RequestMapping("/findOutput")
    @ResponseBody
    public JsonData findOutput(Output output){
        List<Output> outputs = outputService.findOutput(output);
        System.out.println(outputs);
        if(outputs.size()>0){
            return JsonData.buildSuccess(1);
        }else {
            return JsonData.buildError(-1);
        }
    }
    //查询所有退货记录
    @RequestMapping("/findAllOutput")
    @ResponseBody
    public JsonData findAllOutput(Output output,String startTime,String endTime) throws ParseException {
        Date startTime1 = null;
        Date endTime1 = null;
        if (startTime != null && startTime != "") {
            startTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(startTime);
        }
        if (endTime != null && endTime != "") {
            endTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(endTime);
        }
        return JsonData.buildSuccess(outputService.findAllOutput(output,startTime1,endTime1),0);
    }
    //添加退货记录
    @RequestMapping("/addOutput")
    @ResponseBody
    public JsonData addOutput(Integer inportid, Integer currentNumber,String remark, HttpSession session){
        System.out.println(inportid+"$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        User user = (User)session.getAttribute("user");
        Input input = inputService.findInput(inportid);
        Output output = new Output();
        output.setProviderid(input.getProviderid());
        output.setPaytype(input.getPaytype());
        output.setOutporttime(new Date());
        output.setOperateperson(user.getName());
        output.setOutportprice(input.getInportprice());
        output.setNumber(currentNumber);
        output.setRemark(remark);
        output.setGoodsid(input.getGoodsid());
        output.setInportid(input.getGoodsid());
        try {
            int count = outputService.addOutput(output);
            if (count>0){
                return JsonData.buildSuccess(null,"退货成功");
            }else {
                return JsonData.buildError("退货失败",-1);
            }
        }catch (Exception e){
            return JsonData.buildError("退货失败",-1);
        }
    }
}
