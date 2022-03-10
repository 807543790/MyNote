package com.zhangbin.设计模式.单例模式;

public class SingletonNote01 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance2 == instance);
        System.out.println(instance2.hashCode());
        System.out.println(instance.hashCode());
    }

}

//饿汉式(静态变量)
class Singleton{


    //2。本类内部创建对象实例
    private static Singleton instance  = new Singleton();
    //提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance(){
        return instance;
    }

    //1。构造器私有化，外部不能new
    private Singleton(){
    }


}
