package com.zhangbin.dao;


import com.zhangbin.pojo.Blog;
import com.zhangbin.pojo.User;
import com.zhangbin.utils.IdUtils;
import com.zhangbin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/6/21-15:57
 */
public class userDaoTest {
//    一级缓存
    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
//      查询相同的SQL时,启动缓存.（参数SQL相同）
        User userById = mapper.getUserById(91);
        System.out.println(userById);
        //手动关闭缓存,关闭后执行两次SQL，或者执行其他的增删改造作也会清除缓存
        sqlSession.clearCache();
        System.out.println("--------------------------------------------");
        User userById1 = mapper.getUserById(91);
        System.out.println(userById1);
        sqlSession.close();
    }

    //    二级缓存
    @Test
    public void getUserById2(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
//        二级缓存会把一级缓存的东西存在二级缓存。不过二级缓存范围只能在一个XML文件中
        User userById = mapper.getUserById(91);
        System.out.println(userById);
        sqlSession.close();

        User userById2 = mapper2.getUserById(91);
        System.out.println(userById2);
        sqlSession.close();

    }
}
