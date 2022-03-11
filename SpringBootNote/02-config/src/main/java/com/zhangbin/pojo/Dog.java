package com.zhangbin.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/9/1-19:54
 *
 * @controller 控制器（注入服务）
 * 用于标注控制层，相当于struts中的action层
 *
 * @service 服务（注入dao）
 * 用于标注服务层，主要用来进行业务的逻辑处理
 *
 * @repository（实现dao访问）
 * 用于标注数据访问层，也可以说用于标注数据访问组件，即DAO组件
 *
 * @component 把普通pojo实例化到spring容器中，相当于配置文件中的
 *
 */
@Component
public class Dog {
    @Value("张珂")
    private String name;
    @Value("3")
    private Integer age;

    public Dog() {
    }

    public Dog(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
