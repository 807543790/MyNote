package com.zhangbin.dao;

import com.zhangbin.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/11-15:25
 */
public interface StudentMapper {
    @Select("select * from student where id=#{id}")
    Student getStudent(@Param("id") int id);

    //获取所有学生和老师方式一
    List<Student> getStudentTeacher();

    //获取所有学生和老师方式二
    List<Student> getStudentTeacher2();
}
