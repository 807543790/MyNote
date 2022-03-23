package com.zhangbin;

import com.zhangbin.多态.Cat;
import com.zhangbin.多态.Dog;
import com.zhangbin.多态.PatShop;
import org.junit.jupiter.api.Test;

//多态测试类
public class demo1 {
    @Test
    public void run(){
        PatShop p = new PatShop();
        p.washDog(new Dog());
    }

    @Test
    public void run1(){
        PatShop p = new PatShop();
        p.washAll(new Cat());
    }

    @Test
    public void run2(){
        PatShop p = new PatShop();
        p.HelpEat(new Dog());
    }

    @Test
    public void run3(){
        PatShop p = new PatShop();
        p.HelpEat(new Cat());
    }
}
