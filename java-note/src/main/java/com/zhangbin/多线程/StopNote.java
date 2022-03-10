package com.zhangbin.多线程;

public class StopNote {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100 ; i++) {
                    System.out.println(i);
                }
            }
        });
        thread.start();
        thread.stop();
        //结束线程stop
    }

    public void test(){
        System.out.println("反射");
    };
}
