package com.dt87.service;

import com.dt87.entity.Permission;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionService {
    //查询权限 主界面左侧目录
    public List<Permission> findMenu();
    //*********************************************************
    //查询目录（菜单管理用）
    public List<Permission> findAllMenu(Permission permission);
    //查询所有权限 菜单用
    public List<Permission> findAllPermission(Permission permission,Integer page,Integer limit);
    //查询所有权限的条数 菜单用
    //******************************
    public int findAllPermissionCount(Permission permission);
    //查询权限  权限管理界面用
    public List<Permission> findPermission(Permission permission,Integer page,Integer limit);
    //查询所有权限的条数 权限管理界面用
    public int findPermissionCount(Permission permission);
    //查询权限 最大排序码
    public int findPermissionMaxOrderNum();
    //添加权限
    public int addPermission(Permission permission);
    //修改权限
    public int updatePermission(Permission permission);
    //删除权限
    public int deletePermission(Permission permission);
}
