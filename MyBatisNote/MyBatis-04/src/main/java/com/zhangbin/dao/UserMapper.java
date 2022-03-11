package com.zhangbin.dao;

import com.zhangbin.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/9-9:21
 */
public interface UserMapper {

    //分页查询
    List<User> getUserLimit(Map <String,Integer> map);

    //rowBounds分页
    List<User> getUserRow();
}
