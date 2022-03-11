package com.zhangbin.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/9-9:20
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private String token;


}
