package com.dt87.service.impl;

import com.dt87.entity.Permission;
import com.dt87.mapper.PermissionMapper;
import com.dt87.service.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Resource
     private PermissionMapper permissionMapper;
    //查询目录(主界面左侧目录用)
    public List<Permission> findMenu() {
        return permissionMapper.findMenu();
    }
    //*****************************************************
    //查询目录（菜单管理用）
    public List<Permission> findAllMenu(Permission permission) {
        return permissionMapper.findAllMenu(permission);
    }

    //查询所有权限（菜单管理用）
    public List<Permission> findAllPermission(Permission permission,Integer page,Integer limit) {
        return permissionMapper.findAllPermission(permission,page,limit);
    }

    //查询所有权限的条数 菜单用
    public int findAllPermissionCount(Permission permission) {
        return permissionMapper.findAllPermissionCount(permission);
    }
    //**********************************************
    //查询权限  权限管理界面用
    public List<Permission> findPermission(Permission permission, Integer page, Integer limit) {
        return permissionMapper.findPermission(permission, page, limit);
    }

    //查询权限对应条数  权限管理界面用
    public int findPermissionCount(Permission permission) {
        return permissionMapper.findPermissionCount(permission);
    }

    //查询权限 最大排序码
    public int findPermissionMaxOrderNum() {
        return permissionMapper.findPermissionMaxOrderNum();
    }

    //添加权限
    public int addPermission(Permission permission) {
        return permissionMapper.addPermission(permission);
    }

    //修改权限
    public int updatePermission(Permission permission) {
        return permissionMapper.updatePermission(permission);
    }

    //删除权限
    public int deletePermission(Permission permission) {
        return permissionMapper.deletePermission(permission);
    }


}
