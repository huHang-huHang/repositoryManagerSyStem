package com.dt87.mapper;

import com.dt87.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {

    /*User*/
  //根据登入名查询用户
  public User findUser(@Param("loginname") String loginname, @Param("pwd") String pwd);
  //根据登入名查询所有用户(含角色，权限信息)
  public User findPermissions(@Param("loginname") String loginname);
}
