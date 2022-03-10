package com.zhangbin.多线程;

public class SleepNote {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1");
        Thread.sleep(1000);
        System.out.println("2");
        Thread.sleep(1000);
        System.out.println("3");
        Thread.sleep(1000);
        System.out.println("4");
    }
    //线程休眠sleep
}
