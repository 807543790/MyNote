package com.zhangbin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/10/21-13:26
 */
@RestController
public class JdbcController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/hello")
    public List<Map<String,Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql = "insert into user(id,name) values(11,'11张斌')";
        jdbcTemplate.update(sql);
        return "addUser";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(@PathVariable("id") int id){
        String sql = "update user set name='张全蛋' where id = ?";
        jdbcTemplate.update(sql,id);
        return "addUser";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") int id){
        String sql = "delete from user where id=?";
        jdbcTemplate.update(sql,id);
        return "addUser";
    }
}
