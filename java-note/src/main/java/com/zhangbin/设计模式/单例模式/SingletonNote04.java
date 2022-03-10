package com.zhangbin.设计模式.单例模式;

public class SingletonNote04 {
    public static void main(String[] args) {
        Singleton04 instance = Singleton04.getInstance();
        Singleton04 instance1 = Singleton04.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance.hashCode());
        System.out.println("懒汉式，线程安全，同步方法");
    }
}

class Singleton04{
    private static Singleton04 instance;

    private Singleton04(){}

    public static synchronized Singleton04 getInstance(){
        if (instance == null){
            instance = new Singleton04();
        }
        return instance;
    }

}
