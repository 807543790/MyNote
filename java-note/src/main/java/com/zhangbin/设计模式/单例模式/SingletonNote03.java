package com.zhangbin.设计模式.单例模式;

public class SingletonNote03 {
    public static void main(String[] args) {
        Singleton03 instance = Singleton03.getInstance();
        Singleton03 instance1 = Singleton03.getInstance();
        System.out.println(instance == instance1);
        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());
        System.out.println("饱汉式，线程不安全写法");
    }
}

class Singleton03{
    //1.本类内部创建对象实例
    private static Singleton03 instance = new Singleton03();
    //2.构造器私有化，外部不能new
    private Singleton03(){

    }
    //3.提供静态公共方法，返回对象实例
    public static Singleton03 getInstance(){
        if (instance == null){
            instance  = new Singleton03();
        }
        return instance;
    }

}
