package com.dt87.controller;

import com.dt87.Constant;
import com.dt87.entity.Department;
import com.dt87.entity.JsonData;
import com.dt87.service.impl.DepartmentServiceImpl;
import com.dt87.utils.DataGridView;
import com.dt87.utils.TreeNode;
import com.dt87.utils.TreeNodeBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    /**
     * @description:
     * @author: Mr.HuHang
     * @create: 2020-02-27 18:07
     **/
    @Autowired
    private DepartmentServiceImpl departmentService;
    //部门管理左侧 文件数
    /*@RequestMapping("/menu")
    @ResponseBody
    public List<TreeNode> findMenu(Department department) {
        System.out.println("部门管理左侧的树文件"+department);
        List<Department> departments = departmentService.findAllDepartment(department);
        List<TreeNode> list = new ArrayList<>();
        for (Department d:departments){
            TreeNode treeNode = new TreeNode(d.getId(),d.getPid(),d.getTitle(),false);
            list.add(treeNode);
        }
        return TreeNodeBuilder.build(list,1);

    }*/
    @RequestMapping("/menu")
    @ResponseBody
    public DataGridView loadAllDeptTreeJson(Department department) {
        List<Department> departments = departmentService.findAllDepartment(department);
        System.out.println("部门管理左侧的树文件"+department);
        List<TreeNode> treeNodes=new ArrayList<>();
        for (Department d : departments) {
            Integer id=d.getId();
            Integer pid=d.getPid();
            String title=d.getTitle();
            Boolean spread=d.getOpen()==1?true:false;
            treeNodes.add(new TreeNode(id, pid, title, spread));
        }
        return new DataGridView(treeNodes);
    }
    //查询所有部门
    @RequestMapping("/findAllDepartment")
    @ResponseBody
    public JsonData findAllDepartment(Department department){
          System.out.println("****************"+department);
          return JsonData.buildSuccess(departmentService.findAllDepartment(department), 0);
    }
    //加载最大的排序码
    @RequestMapping("/findMaxOrderNum")
    @ResponseBody
    public DataGridView findMaxOrderNum() {
        Integer maxOrderNum= departmentService.findMaxOrderNumber();
        return new DataGridView(maxOrderNum+1);

    }
    //修改部门信息
    @RequestMapping("/updateDepartment")
    @ResponseBody
    public JsonData updateDepartment(Department department) {
        System.out.println(department + "****************************");
        if (department.getAddress() != null && !department.getAddress().equals("") &&
                department.getRemark() != null && !department.getRemark().equals("") &&
                department.getTitle() != null && !department.getTitle().equals("")) {
            try {
                departmentService.updateDepartment(department);
                return JsonData.buildSuccess(null, "修改成功");
            } catch (Exception e) {
                return JsonData.buildError("修改失败呀", -1);
            }
        } else {
            return JsonData.buildError("标题或内容不能为空", -1);
        }
    }

    //添加部门
    @RequestMapping("/addDepartment")
    @ResponseBody
    public JsonData addDepartment(Department department) {
        department.setCreatetime(new Date());
        System.out.println(department+"添加部门");
        try {
            int i = departmentService.addDepartment(department);
            if (i > 0) {
                return JsonData.buildSuccess(null, "添加成功");
            } else {
                return JsonData.buildError("添加失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("添加失败", -1);
        }
    }

    //删除部门  单条
    @RequestMapping("/deleteDepartment")
    @ResponseBody
    public JsonData deleteDepartment(Department department) {
        try {
            int i = departmentService.deleteDepartment(department);
            if (i > 0) {
                return JsonData.buildSuccess(null, "删除成功");
            } else {
                return JsonData.buildError("删除失败", -1);
            }
        } catch (Exception e) {
            return JsonData.buildError("删除失败", -1);
        }
    }
    //查询部门信息  删除前判断其是否有子集部门
    @RequestMapping("/findAllDepartmentById")
    @ResponseBody
    public JsonData findAllDepartmentById(Department department){
        List<Department> departments = departmentService.findAllDepartmentById(department);
        if (departments.size()>0){
            return JsonData.buildSuccess(1);
        }else {
            return JsonData.buildError(-1);
        }
    }
    //删除部门 批量删除
    @RequestMapping("/deleteSelectDepartment")
    @ResponseBody
    public JsonData deleteSelectDepartment(int[] ids) {
        //System.out.println(ids);
        List<Serializable> idList = new ArrayList<Serializable>();
        for (int i = 0; i < ids.length; i++) {
            idList.add(ids[i]);
        }
        System.out.println(idList);
        try {
            System.out.println(123);
            departmentService.deleteSelectDepartment(idList);
            System.out.println(321);
            return JsonData.buildSuccess(null, "删除成功");
        } catch (Exception e) {
            return JsonData.buildError("删除失败", -1);
        }

    }
   /* @RequestMapping("/deleteSelectDepartment")
    @ResponseBody
    public JsonData deleteSelectDepartment(int[] ids) {
        System.out.println(ids);
        Department department = new Department();
        for (int i = 0; i < ids.length; i++) {
            System.out.println(11);
            department.setId(ids[i]);
            departmentService.deleteDepartment(department);

        }
        return JsonData.buildSuccess(null,"删除成功");
    }*/
}
