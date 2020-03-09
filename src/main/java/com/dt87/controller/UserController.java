package com.dt87.controller;

import com.dt87.entity.JsonData;
import com.dt87.entity.Permission;
import com.dt87.entity.User;
import com.dt87.mapper.PermissionMapper;
import com.dt87.service.impl.PermissionServiceImpl;
import com.dt87.service.impl.UserServiceImpl;
import com.dt87.utils.DataGridView;
import com.dt87.utils.TreeNode;
import com.dt87.utils.TreeNodeBuilder;
import com.dt87.vo.PermissionVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PermissionServiceImpl permissionService;
    //登录
    @RequestMapping("/login")
    @ResponseBody
    public JsonData login(String username, String password, HttpSession session){
        //登录的过程 命名好像没有影响用String接收时候 表单name是username也没有影响
        //string 只把对应的值接收过来了 一样是最好 毕竟是验证loginname和password
        /*System.out.println("*******************");
        System.out.println(username);
        System.out.println(password);*/
        User user = userService.findUser(username,password);
        if(user != null && user.getId() != 0){
            session.setAttribute("user",user);
            //先走shiro验证
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            Subject subject = SecurityUtils.getSubject();
            subject.login(usernamePasswordToken);
            return JsonData.buildSuccess(user,0);
        }
        return JsonData.buildError("登录失败",-1);
    }
    //左侧目录  通过封装的工具类生成左侧目录
    /*index.html 133行*/
    @RequestMapping("/munu")
    @ResponseBody
    public List<TreeNode> loadMunu() {
        List<Permission> permissionList =  permissionService.findMenu();
        List<TreeNode> list = new ArrayList<>();
        for (Permission p:permissionList){
            TreeNode treeNode = new TreeNode(p.getId(),p.getPid(),p.getTitle(),p.getHref(),p.getIcon(),false);
            list.add(treeNode);
        }
        return TreeNodeBuilder.build(list,1);

    }
    /**
     * 生成菜单json树
     */
    /*@RequestMapping("/loadAllMenuTreeJson")
    public DataGridView loadMenu() {
        List<Permission> permissionList =  permissionService.findMenu();
        List<TreeNode> list = new ArrayList<>();
        for (Permission p:permissionList){
            TreeNode treeNode = new TreeNode(p.getId(),p.getPid(),p.getTitle(),p.getHref(),p.getIcon(),false);
            list.add(treeNode);
        }
        return new DataGridView(list);

    }*/
}
