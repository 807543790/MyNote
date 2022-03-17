package com.zhangbin.多线程;

public class joinNote {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2222222222");
            }
        });
        t1.start();
//      t1.join();
/**
 *          正常情况下，会先执行mian方法的sout，然后间隔3秒执行run方法的sout的.
 *          mian方法
 *          222222222
 *
 *          但是如果在mian方法中调用join，则会先执行run方法，然后再执行main方法的sout.
 *          2222222222
 *          mian方法
 */


        System.out.println("mian方法");
    }
}
