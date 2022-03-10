package com.zhangbin.设计模式.单例模式;

public class SingletonTest02 {
    public static void main(String[] args) {
        Singleton02 instance = Singleton02.getInstance();
        Singleton02 instance1 = Singleton02.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
    }
}

class Singleton02{
    //1.构造器私有化，外部不能new
    private Singleton02(){

    }
    //2.本类内部创建对象实例
    private static Singleton02 instance;

    static{
        instance = new Singleton02();
    }
    //3.提供一个公有的静态方法，返回对象实例
    public static Singleton02 getInstance(){
        return instance;
    }

}
