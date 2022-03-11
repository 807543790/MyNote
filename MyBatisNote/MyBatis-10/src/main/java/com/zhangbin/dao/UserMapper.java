package com.zhangbin.dao;

import com.zhangbin.pojo.User;
import org.apache.ibatis.annotations.Param;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/15-23:01
 */
public interface UserMapper{
    User getUserById(@Param("id") int id);
}
