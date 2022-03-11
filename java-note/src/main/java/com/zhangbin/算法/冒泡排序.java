package com.zhangbin.算法;

import java.util.ArrayList;
//冒泡排序
public class 冒泡排序 {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);

        int arr[] ={1,6,4,3,7,34,567,24,234,456,13};
      int sum = 0;
        for (int i = 0; i <arr.length - 1 ; i++) {
            for (int j = 0; j <arr.length - 1 -i ; j++) {
                if(arr[j] > arr[j+1]){
                    sum = arr[j];
                    arr[j] =arr[j+1];
                    arr[j+1] = sum;
                }
            }
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.print(arr[i]+"-");
        }
    }
}
