package com.zhangbin.dao;


import com.zhangbin.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/9/5-9:12
 */
//部门dao
@Repository
public class DepartmentDao {
//    模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer,Department>();//创建一个部门

        departments.put(101,new Department(101,"科技部"));
        departments.put(102,new Department(102,"财务部"));
        departments.put(103,new Department(103,"保卫部"));
        departments.put(104,new Department(104,"人事部"));
        departments.put(105,new Department(105,"市场部"));
    }

//    获得所有部门信息
    public Collection<Department> getDepartment(){
        return departments.values();
    }
//    通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
