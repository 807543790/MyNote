package com.zhangbin.dao;


import com.zhangbin.pojo.Blog;
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

    //插入数据
    @Test
    public void addBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IdUtils.getId());
        blog.setTitle("MyBatis简单");
        blog.setAuthor("张斌");
        blog.setCreateTime(new Date());
        blog.setViews(999);

        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("java简单");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("spring");
        mapper.addBlog(blog);

        blog.setId(IdUtils.getId());
        blog.setTitle("springBoot简单");
        mapper.addBlog(blog);


        sqlSession.close();
    }

//    动态SQL之if
    @Test
    public void getBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
//        添加数据就是IF查询
//        map.put("title","java简单");
        List<Blog> blogsIF = mapper.getBlogsIF(map);
        for (Blog blog : blogsIF) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    //    动态SQL之Choose
    @Test
    public void getBlogChoose(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        //map.put("title","java简单");
        List<Blog> blogsIF = mapper.getBlogsChoose(map);
        for (Blog blog : blogsIF) {
            System.out.println(blog);
        }

        sqlSession.close();
    }

    //    动态SQL之Choose
    @Test
    public void UpdateBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap map = new HashMap();
        map.put("title","MyBatis简单吗");
        map.put("id","214d30fd0b2944bda43c4c53fac9f471");
        int i = mapper.updateBlog(map);
        System.out.println(i);
        sqlSession.close();
    }

    //动态SQL之ForEach
    @Test
    public void selectBlog(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        HashMap map = new HashMap();
        map.put("ids",arrayList);
        List<Blog> blogForEach = mapper.getBlogForEach(map);
        for (Blog forEach : blogForEach) {
            System.out.println(forEach);
        }
        sqlSession.close();
    }
}
