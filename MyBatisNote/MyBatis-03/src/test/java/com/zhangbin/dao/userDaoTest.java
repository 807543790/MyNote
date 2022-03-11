package com.zhangbin.dao;

import com.zhangbin.utils.MyBatisUtils;
import com.zhangbin.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/6/21-15:57
 */
public class userDaoTest {
    @Test
    public void test(){
//        第一步：获取sqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

//        方式一：getMapper
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        //关闭sqlSession
        sqlSession.close();
    }

}
