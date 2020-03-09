package com.dt87.controller;

import com.dt87.entity.JsonData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/file")
public class FileController {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-03-02 17:30
     **/
    @RequestMapping("/uploadFile")
    @ResponseBody
    public JsonData uploadFile(MultipartFile file) {
       // System.out.println(file.getOriginalFilename());
        String desFilePath = "";         //图片保存路径
        String oriName = "";             //原文件名
        Map<String, String> dataMap = new HashMap<>();
        try {
            // 1.获取原文件名
            oriName = file.getOriginalFilename();
            // 2.获取原文件图片后缀，以最后的.作为截取(.jpg)
            String extName = oriName.substring(oriName.lastIndexOf("."));
            // 4.获取要保存的路径文件夹
            //String realPath = "D:\\idea\\src\\main\\resources\\static\\resources\\images";
            String realPath = "D:\\idea\\wms\\src\\main\\resources\\static\\resources\\images";
            // 5.保存图片
            desFilePath = realPath + "\\" + oriName;                //保存路径
            System.out.println("*************"+desFilePath);
            // 6.返回保存结果信息
            dataMap = new HashMap<>();
            dataMap.put("src", oriName); //保存真实路径
           // System.out.println("*************"+dataMap);
            return JsonData.buildSuccess(dataMap, 0);
        } catch (IllegalStateException e) {
            System.out.println(desFilePath + "图片保存失败");
            return JsonData.buildError("失败", -1);
        }
    }
}
