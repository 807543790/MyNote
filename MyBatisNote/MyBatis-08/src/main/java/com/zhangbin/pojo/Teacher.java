package com.zhangbin.pojo;

import lombok.Data;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/11-15:21
 */
@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student> students;
}
