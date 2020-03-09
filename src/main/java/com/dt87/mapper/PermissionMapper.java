package com.dt87.mapper;

import com.dt87.entity.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface PermissionMapper {
    //查询目录（大的功能模块）
    public List<Permission> findMenu();
    //查询目录（菜单管理用）
    public List<Permission> findAllMenu(@Param("permission") Permission permission);
    //查询所有权限(菜单管理用)
    public List<Permission> findAllPermission(@Param("permission") Permission permission,@Param("page") Integer page,@Param("limit") Integer limit);
    //查询所有权限的条数
    public int findAllPermissionCount(@Param("permission") Permission permission);
    //分开写算了 几个界面都用
    //查询权限  权限管理界面用
    public List<Permission> findPermission(@Param("permission") Permission permission,@Param("page") Integer page,@Param("limit") Integer limit);
    //查询所有权限的条数 权限管理界面用
    public int findPermissionCount(@Param("permission") Permission permission);
    //查询权限 最大排序码
    public int findPermissionMaxOrderNum();
    //添加权限
    public int addPermission(@Param("permission") Permission permission);
    //修改权限
    public int updatePermission(@Param("permission") Permission permission);
    //删除权限
    public int deletePermission(@Param("permission") Permission permission);
}
