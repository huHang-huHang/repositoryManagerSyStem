package com.dt87.mapper;

import com.dt87.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Mapper
public interface DepartmentMapper {
    //查询所有部门
    //public List<Department> findAllDepartment(@Param("department") Department department, @Param("startTime") Date startTime,@Param("endTime") Date endTime);
    public List<Department> findAllDepartment(@Param("department") Department department);
    //查询该部分是否有子节点 删除之前要判断
    public List<Department> findAllDepartmentById(@Param("department") Department department);
    //修改部门信息
    public int updateDepartment(@Param("department") Department department);
    //添加部门成员信息
    public int addDepartment(@Param("department") Department department);
    //删除部门信息
    public int deleteDepartment(@Param("department") Department department);
    //批量删除部门信息
    public int deleteSelectDepartment(@Param("ids") List<Serializable> ids);
    //查询最大的排序数
    public int findMaxOrderNumber();
}
