package com.dt87.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transform")
public class TransformController {
    //去首页index
    @RequestMapping("/index")
    public String index(){
        return "system/index";
    }
    //去登入界面
    @RequestMapping("/need_login")
    public String tologin(){
        return "system/login";
    }

    //进入首页后  首先显示左侧导航栏的后台首页界面
    /*index.html  102行*/
    @RequestMapping("/toDeskManager")
    public String toDeskManager(){
        return "system/deskManager";
    }
}
