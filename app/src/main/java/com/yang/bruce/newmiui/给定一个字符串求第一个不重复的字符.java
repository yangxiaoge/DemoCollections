package com.yang.bruce.newmiui;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author: 0027008122 [yang.jianan@zte.com.cn]
 * Time: 2016-10-17 16:18
 * Version: 1.0
 * TaskId:
 * Description:
 * 给定一个字符串,求第一个不重复的字符 abbcad -> c
 * http://www.voidcn.com/blog/codeemperor/article/p-5710794.html
 */

public class 给定一个字符串求第一个不重复的字符 {

    public static void main(String[] args) {
        System.out.println(get("abbcad"));
        System.out.println(get("alibaba"));
        System.out.println(get("taobao"));
        System.out.println(get("aabbccd"));
        System.out.println(get("ddbbdd"));
        System.out.println(get("ahsdkdhask"));
    }

    /** * 返回第一个不重复的字符 * @param s 所求的字符串 * @return 如果有返回该字符，如果不存在不重负的字符，返回null */
    public static Character get(String s) {
        // 判断边界条件
        if (s == null || s.length() < 1) {
            // 抛出异常
            throw new IllegalArgumentException("should not be null or empty");
        }
        Map<Character, Integer> map = new LinkedHashMap<>();
        int len = s.length();

        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            Integer already = map.get(c);
            already = (already == null) ? 0 : already;
            map.put(c, ++already);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }
}
