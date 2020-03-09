package com.dt87.service.impl;

import com.dt87.entity.Department;
import com.dt87.entity.Notice;
import com.dt87.mapper.DepartmentMapper;
import com.dt87.service.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-27 17:16
     **/
    @Resource
    private DepartmentMapper departmentMapper;
    //查询所有部门
   /* public List<Department> findAllDepartment(Department department ,Date startTime, Date endTime) {
        return departmentMapper.findAllDepartment(department,startTime,endTime);
    }*/
    public List<Department> findAllDepartment(Department department) {
        return departmentMapper.findAllDepartment(department);
    }

    //查询该部分是否有子节点 删除之前要判断
    @Transactional
    public List<Department> findAllDepartmentById(Department department) {
        return departmentMapper.findAllDepartmentById(department);
    }

    //修改部门信息
    @Transactional
    public int updateDepartment(Department department) {
        return departmentMapper.updateDepartment(department);
    }

    //添加部门成员信息
    @Transactional
    public int addDepartment(Department department) {
        return departmentMapper.addDepartment(department);
    }

    //删除部门信息
    @Transactional
    public int deleteDepartment(Department department) {
        return departmentMapper.deleteDepartment(department);
    }

    //批量删除部门信息
    public int deleteSelectDepartment(List<Serializable> ids) {
        return departmentMapper.deleteSelectDepartment(ids);
    }

    //查询最大的排序数
    public int findMaxOrderNumber() {
        return departmentMapper.findMaxOrderNumber();
    }

}
