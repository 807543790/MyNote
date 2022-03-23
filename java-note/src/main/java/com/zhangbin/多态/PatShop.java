package com.zhangbin.多态;
//开一家宠物店
public class PatShop {
    /**
     添加一个方法，就可以让狗狗来洗澡
     但是方法单一，设置什么参数就只能传什么参数
     而且只能通过多态创建多个洗澡方法来满足需求，不合理
    */
    public void washDog(Dog d) {
        System.out.println("只能给狗洗澡");
    }

    /**
     *  创建一个宠物类（Pat）将所有宠物继承宠物类，然后将洗澡方法的参数修改为宠物类
     *  即使参数是父类宠物，但是也可以传入多个子类实现不同的宠物洗澡
     */

    public void washAll(Pat c) {
        System.out.println("可以给全部的宠物洗澡");
    }


    /**
     * 创建帮助宠物吃饭方法,虽然解决了传入多种宠物的问题，但是吃的东西是固定的不符合逻辑，
     * 所以宠物子类要重写吃饭的方法，根据自己的宠物吃对应的宠物粮
     */

    public void HelpEat(Pat p){
        p.eat();
    }

}


