package com.zhangbin.算法;

public class 素数 {
//    题目：判断101-200之间有多少个素数，并输出所有素数。
//    程序分析：判断素数的方法：用一个数分别去除2到sqrt(这个数)，如果能被整除， 则表明此数不是素数，反之是素数。
    public static void main(String[] args) {
        String s = "";
        s.equals("2");
        for (int i = 101; i <=200 ; i++) {
            if(i % 2 == 1){
                System.out.println(i);
            }
        }
    }

}
