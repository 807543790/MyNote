package com.zhangbin.utils;

import org.junit.Test;

import java.util.UUID;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/14-17:03
 */
public class IdUtils {
//    自动一个UUID，使用字符串截取去除-符号
    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
