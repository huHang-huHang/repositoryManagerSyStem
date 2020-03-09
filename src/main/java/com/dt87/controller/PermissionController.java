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

@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private PermissionServiceImpl permissionService;
    //查询左侧菜单目录
    @RequestMapping("/findPermissionMenu")
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
    @RequestMapping("/findPermission")
    @ResponseBody
    public String findMenu(Permission permission,Integer page,Integer limit){
        JSONObject jsonObject = new JSONObject();
        int start = (page - 1) * limit;
        jsonObject.put("code", 0);
        jsonObject.put("msg", "");
        jsonObject.put("count", permissionService.findPermissionCount(permission));
        jsonObject.put("data",permissionService.findPermission(permission, start, limit));
        return jsonObject.toString();

    }
    //加载权限的最大排序码
    @RequestMapping("/findPermissionMaxOrderNum")
    @ResponseBody
    public DataGridView findPermissionMaxOrderNum(){
        Integer maxOrderNum= permissionService.findPermissionMaxOrderNum();
        return new DataGridView(maxOrderNum+1);
    }
    //修改权限信息
    @RequestMapping("/updatePermission")
    @ResponseBody
    public JsonData updatePermission(Permission permission) {

        System.out.println(permission + "****************************");
            try {
                int count = permissionService.updatePermission(permission);
                if (count>0){
                    return JsonData.buildSuccess(null, "修改成功");
                }else{
                    return JsonData.buildError("修改失败呀", -1);
                }
            } catch (Exception e) {
                return JsonData.buildError("修改失败", -1);
            }
        }


    //添加权限
    @RequestMapping("/addPermission")
    @ResponseBody
    public JsonData addPermission(Permission permission) {
        permission.setType("permission");
        System.out.println(permission+"添加权限");
        try {
            int i = permissionService.addPermission(permission);
            if (i > 0) {
                return JsonData.buildSuccess(null, "添加成功");
            } else {
                return JsonData.buildError("添加失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("添加失败了", -1);
        }
    }

    //删除权限  单条
    @RequestMapping("/deletePermission")
    @ResponseBody
    public JsonData deletePermission(Permission permission) {
        try {
            int i = permissionService.deletePermission(permission);
            if (i > 0) {
                return JsonData.buildSuccess(null, "删除成功");
            } else {
                return JsonData.buildError("删除失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("删除失败了", -1);
        }
    }
    //
  }
