package com.zhangbin.pojo;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/9-9:20
 */
public class User {
    private Integer id;
    private String username;
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User(Integer id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
