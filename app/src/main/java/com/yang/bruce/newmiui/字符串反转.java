package com.yang.bruce.newmiui;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-10-18 9:58
 * Version: 1.0
 * TaskId:
 * Description:
 */

public class 字符串反转 {
    public static String a = "I am a Student";

    public static void main(String[] args) {
        String b = "";
        String[] ss = a.split(" ");
        for (int i = ss.length - 1; i >= 0; i--) {
            b += ss[i] + " ";
        }
        System.out.println("反转字符串: " + b);
    }

}
