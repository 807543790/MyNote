package com.zhangbin.pojo;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/9-9:20
 */
public class User {

    private Integer id;
    private String name;
    private String token;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User(Integer id, String name, String token) {
        this.id = id;
        this.name = name;
        this.token = token;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
