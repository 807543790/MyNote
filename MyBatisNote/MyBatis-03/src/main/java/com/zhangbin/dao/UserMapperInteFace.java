package com.zhangbin.dao;

import com.zhangbin.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/9-10:04
 */
public interface UserMapperInteFace {
    //使用注解查询
    @Select("SELECT * FROM userdata")
    List<User> getUser();
}
