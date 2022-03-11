package com.zhangbin.dao;

import com.zhangbin.pojo.User;
import com.zhangbin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/9-9:26
 */
public class UserDaoTest {

    //查询所有数据
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


    //根据ID查询数据
    @Test
    public void test01(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(91);
        System.out.println(user);

        sqlSession.close();

    }

    //插入数据
    @Test
    public void test02(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(95,"zhangbin","token");
        mapper.addUser(user);
        //插入数据要提交事务才能执行
        sqlSession.commit();
        sqlSession.close();
    }

    //更新数据
    @Test
    public void test03(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(5,"张斌","token1"));
        sqlSession.commit();
        sqlSession.close();
    }

    //删除数据
    @Test
    public void test04(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(95);
        sqlSession.commit();
        sqlSession.close();
    }

    //使用map添加数据（不需要定义参数）
    @Test
    public void test05(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userid",5);
        map.put("username","map");
        map.put("usertoken","token");

        mapper.addUser1(map);
        sqlSession.commit();
        sqlSession.close();
    }

    //使用map更新数据（不需要定义参数）
    @Test
    public void test06(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("username","zzzzz");
        map.put("usertoken","tttttt");
        map.put("userid",5);
        mapper.updateUser1(map);
        sqlSession.commit();
        sqlSession.close();
    }

    //使用map进行模糊查询
    @Test
    public void test07(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserLike("%z%");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    //使用注解查询数据（简单SQL可以使用）
    @Test
    public void test08(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapperInteFace mapper = sqlSession.getMapper(UserMapperInteFace.class);
        List<User> user = mapper.getUser();
        for (User user1 : user) {
            System.out.println(user1);
        }


        sqlSession.close();
    }

}
