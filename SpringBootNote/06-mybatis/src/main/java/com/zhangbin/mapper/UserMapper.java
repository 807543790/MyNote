package com.zhangbin.mapper;

import com.zhangbin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/10/22-13:24
 */
//这个注释表示这是一个mybatis的mapper类
@Mapper
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryUserById(int id);


}
