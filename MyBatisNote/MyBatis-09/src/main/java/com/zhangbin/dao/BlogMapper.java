package com.zhangbin.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zhangbin.pojo.Blog;

import java.util.List;
import java.util.Map;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/14-16:07
 */
public interface BlogMapper {
    //添加数据
    int addBlog(Blog blog);

    //动态SQL之IF
    List<Blog> getBlogsIF(Map map);

    //动态SQL之IF
    List<Blog> getBlogsChoose(Map map);

    //动态SQL之SET
    int updateBlog(Map map);

    //动态SQL之foreach
    List<Blog> getBlogForEach(Map map);
}
