package com.zhangbin.dao;

import com.zhangbin.pojo.User;
import org.apache.ibatis.annotations.*;

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


    //方法存在多个参数，所有参数必须加上@Param注解。
    // #{id}对应的是@param中的id。
    @Select("select * from userdata where id=#{id}")
    User getUserById(@Param("id") int id);

    //使用注解插入数据
    @Insert("insert into userdata(id,name,token) values(#{id},#{name},#{token})")
    int addUser(User user);

    //使用注解更新数据
    @Update("update  userdata set name=#{name} where id=#{id}")
    int updateUser(@Param("name") String name,@Param("id") int id);

    //使用注解删除数据
    @Delete("delete from userdata where id=#{id}")
    int deleteUser(@Param("id") int id);
}
