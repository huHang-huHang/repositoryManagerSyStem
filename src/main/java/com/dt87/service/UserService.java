package com.dt87.service;

import com.dt87.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    /*User*/
    //根据登入名查询用户
    public User findUser(String loginname, String pwd);
    //根据登入名查询所有用户(含角色，权限信息)
    public User findPermissions(@Param("loginname") String loginname);
}
