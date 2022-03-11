package com.zhangbin.dao;

import com.zhangbin.pojo.User;
import com.zhangbin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/6/21-15:57
 */
public class userDaoTest {

    //使用注解查询数据@Param
    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapperInteFace mapper = sqlSession.getMapper(UserMapperInteFace.class);
        User userById = mapper.getUserById(91);
        System.out.println(userById);

        sqlSession.close();
    }

    //使用注解添加数据
    @Test
    public void addUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapperInteFace mapper = sqlSession.getMapper(UserMapperInteFace.class);
        User user = new User(15,"张斌","123456");
        int i = mapper.addUser(user);
        System.out.println(i);
        sqlSession.close();
    }
    //使用注解删除数据
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapperInteFace mapper = sqlSession.getMapper(UserMapperInteFace.class);
        int i = mapper.deleteUser(5);
        System.out.println(i);
        sqlSession.close();
    }

    //使用注解更新数据
    @Test
    public void updateUser(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapperInteFace mapper = sqlSession.getMapper(UserMapperInteFace.class);
        int i = mapper.updateUser("张全蛋", 15);
        System.out.println(i);
        sqlSession.close();
    }

}
