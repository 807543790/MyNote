package com.zhangbin.多线程;

public class RunnableNote implements Runnable{
    @Override
    public void run() {
        System.out.println("2");
    }
}

class RunnableNoteTest{
    public static void main(String[] args) {
        RunnableNote T1 = new RunnableNote();
        Thread thread = new Thread(T1,"1");
        Thread thread2 = new Thread(T1,"12");
        thread.start();
        System.out.println(thread.getName());
        thread2.start();
        System.out.println(thread2.getName());
    }
}
