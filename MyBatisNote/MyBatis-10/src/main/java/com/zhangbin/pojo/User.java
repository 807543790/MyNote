package com.zhangbin.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/15-23:00
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;

}
