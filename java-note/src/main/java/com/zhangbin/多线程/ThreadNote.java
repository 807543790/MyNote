package com.zhangbin.多线程;

public class ThreadNote {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("我是线程"+i);
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    System.out.println("你是线程"+i);
                }
            }
        });
        thread.start();
        thread1.start();
    }
}
