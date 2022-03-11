package com.zhangbin.service;

import com.zhangbin.mapper.UserMapper;
import com.zhangbin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/10/28-13:56
 */
@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    UserMapper userMapper;

    @Override
    public User queryUserByName(String name) {
        return userMapper.queryUserByName(name);
    }
}
