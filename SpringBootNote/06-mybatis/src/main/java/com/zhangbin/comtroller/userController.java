package com.zhangbin.comtroller;

import com.zhangbin.mapper.UserMapper;
import com.zhangbin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/10/22-13:41
 */
@RestController
public class userController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("list")
    public List<User> queryUserList(){
        List<User> users = userMapper.queryUserList();
        for (User user : users) {
            System.out.println(user);
        }
        return users;
    }
}
