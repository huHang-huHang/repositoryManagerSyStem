package com.dt87.config;


import com.dt87.entity.Permission;
import com.dt87.entity.Role;
import com.dt87.entity.User;
import com.dt87.service.impl.UserServiceImpl;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-19 20:29
     **/
    @Autowired
    private UserServiceImpl userService;
    //授权
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取传来的用户名
        System.out.println("开始授权");
        String loginname = (String )principalCollection.getPrimaryPrincipal();
        //存角色，权限的集合
        //System.out.println("*******用户名********"+loginname);
        Set<String> role = new HashSet<String>();
        Set<String> permission = new HashSet<String>();
        //根据用户信息 条用户实现类方法将从数据库查到对应角色和权限的信息取出来存在对应集合里面
        User users = userService.findPermissions(loginname);
        List<Role> roles = users.getRoleList();
        //System.out.println("!!!!!!!!!!!!!!!!!!!!!!"+roles);
        for (Role r:roles) {
             role.add(r.getName());
            for (Permission p:r.getPermissionList()) {
                permission.add(p.getPercode());
            }
        }
        //System.out.println("****用户拥有的角色：******"+role);
        //System.out.println("*****用户拥有的权限：*******"+permission);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(role);
        simpleAuthorizationInfo.setStringPermissions(permission);
        //将相关角色，权限的信息封装在simpleAuthorizationInfo
        System.out.println("授权结束");
        return simpleAuthorizationInfo;
    }

    //认证
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始认证");
        //获取前台传来的信息 用户名
       String loginname =(String) authenticationToken.getPrincipal();
       //根据前端信息查询数据库的信息
        User user = userService.findPermissions(loginname);
        if(user==null){
            return null;
        }
        //将查的信息封装在simpleAuthenticationInfo 传递
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(loginname,user.getPwd(),this.getClass().getName());
        return simpleAuthenticationInfo;
    }


}
