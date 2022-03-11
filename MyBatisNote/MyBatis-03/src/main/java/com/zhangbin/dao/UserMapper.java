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
    //    获取全部user对象
    List<User> getUserList();
    //    根据ID获取对象
    User getUserById(int id);
    //    插入数据
    int addUser(User user);
    //    更新数据
    int updateUser(User user);
    //    删除数据
    int deleteUser(int id);
    //    map插入数据
    int addUser1(Map<String, Object> map);
    //    map修改数据
    int updateUser1(Map<String, Object> map);
    //   模糊查询
    List<User> getUserLike(String value);
}
