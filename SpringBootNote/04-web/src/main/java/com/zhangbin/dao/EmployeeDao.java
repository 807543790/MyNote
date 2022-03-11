package com.zhangbin.dao;

import com.zhangbin.pojo.Department;
import com.zhangbin.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/9/5-9:44
 */
@Repository
//    模拟数据库中的数据
public class EmployeeDao {
    public static Map<Integer, Employee> employees = null;
//    员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static{
        employees = new HashMap<Integer,Employee>();//创建一个部门表
        employees.put(1001,new Employee(1001,"张1","123456@qq.com",0,new Department(101,"科技部"),new Date()));
        employees.put(1002,new Employee(1002,"张2","123456@qq.com",1,new Department(102,"财务部"),new Date()));
        employees.put(1003,new Employee(1003,"张3","123456@qq.com",0,new Department(103,"保卫部"),new Date()));
        employees.put(1004,new Employee(1004,"张4","123456@qq.com",1,new Department(104,"人事部"),new Date()));
        employees.put(1005,new Employee(1005,"张5","123456@qq.com",0,new Department(105,"市场部"),new Date()));

    }

//    主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee){
        if (employee.getId() == null){
//            主键ID自增
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(),employee);
    }

//    查询所有员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

//    通过id查询员工
    public Employee getEmployee(Integer id){
        return employees.get(id);
    }
//    通过id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}

