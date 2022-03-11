package com.zhangbin.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/9/1-20:00
 *
 *  @ConfigurationProperties(prefix = "person")
 *   作用：
 *     将配置文件中的配置的每一个属性的值，映射到这个组件中告诉springboot
 *     将本类中所有的属性和配置文件中能拿个的相关配置进行绑定
 *     只有这个组件是容器中的组件，才能使用@ConfigurationProperties
 */
@Component
@ConfigurationProperties(prefix = "person")
@Validated//数据校验
public class person {

    @Email(message = "邮箱不合法")
    private String name;
    private Integer age;
    private Boolean happy;
    private Date birthday;
    private Map<String,Object> maps;
    private List<Object> lists;
    private Dog dog;

    public person(String name, Integer age, Boolean happy, Date birthday, Map<String, Object> maps, List<Object> lists, Dog dog) {
        this.name = name;
        this.age = age;
        this.happy = happy;
        this.birthday = birthday;
        this.maps = maps;
        this.lists = lists;
        this.dog = dog;
    }

    public person() {
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", happy=" + happy +
                ", birthday=" + birthday +
                ", maps=" + maps +
                ", lists=" + lists +
                ", dog=" + dog +
                '}';
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

    public Boolean getHappy() {
        return happy;
    }

    public void setHappy(Boolean happy) {
        this.happy = happy;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, Object> getMaps() {
        return maps;
    }

    public void setMaps(Map<String, Object> maps) {
        this.maps = maps;
    }

    public List<Object> getLists() {
        return lists;
    }

    public void setLists(List<Object> lists) {
        this.lists = lists;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
