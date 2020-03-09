package com.dt87.controller;

import com.dt87.entity.Department;
import com.dt87.entity.JsonData;
import com.dt87.entity.Permission;
import com.dt87.service.impl.PermissionServiceImpl;
import com.dt87.utils.DataGridView;
import com.dt87.utils.TreeNode;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private PermissionServiceImpl permissionService;
     //查询左侧菜单目录
    @RequestMapping("/findAllMenu")
    @ResponseBody
    public DataGridView findAllMenu(Permission permission){
        List<Permission> menus = permissionService.findAllMenu(permission);
        List<TreeNode> treeNodes = new ArrayList<>();
        for (Permission menu:menus) {
            Integer id = menu.getId();
            Integer pid = menu.getPid();
            String title = menu.getTitle();
            Boolean spread = menu.getOpen()==1?true:false;
            treeNodes.add(new TreeNode(id,pid,title,spread));
        }
        return new DataGridView(treeNodes);
    }
    //查询菜单 主
    @RequestMapping("/findMenu")
    @ResponseBody
    public String findMenu(Permission permission,Integer page,Integer limit){
        JSONObject jsonObject = new JSONObject();
        int start = (page - 1) * limit;
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", permissionService.findAllPermissionCount(permission));
        jsonObject.put("data",permissionService.findAllPermission(permission, start, limit));
        return jsonObject.toString();

    }
}
