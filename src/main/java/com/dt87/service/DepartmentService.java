package com.dt87.service;

import com.dt87.entity.Department;
import com.dt87.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public interface DepartmentService {
    //查询所有部门
    //public List<Department> findAllDepartment(Department department, Date startTime, Date endTime);
    public List<Department> findAllDepartment(Department department);
    //查询该部分是否有子节点 删除之前要判断
    public List<Department> findAllDepartmentById(Department department);
    //修改部门信息
    public int updateDepartment(Department department);
    //添加部门成员信息
    public int addDepartment(Department department);
    //删除部门信息
    public int deleteDepartment(Department department);
    //批量删除部门信息
    public int deleteSelectDepartment(List<Serializable> ids);
    //查询最大的排序数
    public int findMaxOrderNumber();
}
