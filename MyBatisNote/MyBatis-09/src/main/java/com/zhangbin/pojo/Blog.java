package com.zhangbin.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/14-16:04
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
//        解决字段名称不统一的问题
//        mapUnderscoreToCamelCase:是否开启驼峰命名自动映射，即从经典数据库列名 A_COLUMN 映射到经典 Java 属性名 aColumn
//        <setting name="mapUnderscoreToCamelCase" value="true"></setting>
    private Date createTime;
    private int views;
}
