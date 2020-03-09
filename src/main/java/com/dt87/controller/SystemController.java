package com.dt87.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/system")
public class SystemController {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-24 16:35
     **/
    //跳转到系统公告界面
    @RequestMapping("/toNoticeManager")
    public String toNoticeManager() {
        return "system/notice/noticeManager";
    }
    //系统公告跳部门管理
    // /system/toDeptManager 路径是数据库设计好的 permission 表中href字段 在根据封装工具生成的页面
    @RequestMapping("/toDeptManager")
    public String  departmentMenu(){

        return "system/department/deptManager";
    }
    @RequestMapping("/toDeptLeftManager")
    public String  toDeptLeftManager(){

        return "system/department/deptLeftManager";
    }
    @RequestMapping("/toDeptRightManager")
    public String  toDeptRightManager(){

        return "system/department/deptRightManager";
    }
    //跳菜单管理
    @RequestMapping("/toMenuManager")
    public String  menu(){

        return "system/menu/menuManager";
    }
    @RequestMapping("/toMenuLeftManager")
    public String  toMenuLeftManager(){

        return "system/menu/menuLeftManager";
    }
    @RequestMapping("/toMenuRightManager")
    public String  toMenuRightManager(){

        return "system/menu/menuRightManager";
    }
    //跳权限管理
    @RequestMapping("/toPermissionManager")
    public String permission(){
        return "system/permission/permissionManager";
    }
    //权限管理分左右部分
    @RequestMapping("/toPermissionLeftManager")
    public String leftPermission(){
        return "system/permission/permissionLeftManager";
    }
    @RequestMapping("/toPermissionRightManager")
    public String RightPermission(){
        return "system/permission/permissionRightManager";
    }
}
