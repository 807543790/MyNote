package com.zhangbin.dao;

import com.zhangbin.pojo.Student;
import com.zhangbin.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/11-15:25
 */
public interface TeacherMapper {
//    方式一
    Teacher getTeacher(@Param("tid") int id);
//    方式二
    Teacher getTeacher2(@Param("tid") int id);
}
