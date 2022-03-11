package com.zhangbin.dao;

import com.zhangbin.pojo.User;
import com.zhangbin.utils.MyBatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/6/21-15:57
 */
public class userDaoTest {

    static Logger logger = Logger.getLogger(userDaoTest.class);

    //通过LIMIT分页查询
    @Test
    public void test02(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> maps = new HashMap<String, Integer>();
        maps.put("num",0);
        maps.put("number",2);

        List<User> userLimit = mapper.getUserLimit(maps);
        for (User user : userLimit) {
            System.out.println(user);
        }
        sqlSession.close();

    }

    //方式一：通过RowBonds分页查询
    @Test
    public void getUserRowBounds(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        List<User> user = sqlSession.selectList("com.zhangbin.dao.UserMapper.getUserRow");
        for (User user1 : user) {
            System.out.println(user1);
        }
        sqlSession.close();
    }
    //方式二：通过RowBonds分页查询
    @Test
    public void getUserRowBound(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //通过RowBonds分页查询
        RowBounds rowBounds = new RowBounds(1, 2);

        List<User> user = sqlSession.selectList("com.zhangbin.dao.UserMapper.getUserRow",null,rowBounds);
        for (User user1 : user) {
            System.out.println(user1);
        }
        sqlSession.close();
    }

}
