package com.zhangbin.mapper;

import com.zhangbin.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/10/28-13:51
 */
@Repository
@Mapper
public interface UserMapper {

    User queryUserByName(String name);
}
