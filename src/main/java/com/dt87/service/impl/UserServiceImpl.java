package com.dt87.service.impl;

import com.dt87.entity.User;
import com.dt87.mapper.UserMapper;
import com.dt87.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-15 21:11
     **/
    @Resource
    private UserMapper userMapper;


    //User
    //根据登入名查询用户
    public User findUser(String loginname, String pwd) {
        return userMapper.findUser(loginname, pwd);
    }



    //根据登入名查询所有用户(含角色，权限信息)
    public User findPermissions(String loginname) {
        return userMapper.findPermissions(loginname);
    }


}
