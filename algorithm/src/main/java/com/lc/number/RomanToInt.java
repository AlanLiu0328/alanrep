package com.lc.number;

import java.util.HashMap;
import java.util.Map;

/**
 * 13
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 */
public class RomanToInt {
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>() {
            {
                put("I", 1);
                put("V", 5);
                put("X", 10);
                put("L", 50);
                put("C", 100);
                put("D", 500);
                put("M", 1000);
            }
        };

        char[] chs = s.toCharArray();
        int count = 0;
        for (int i = 0; i < chs.length - 1; i++) {
            if (map.get(String.valueOf(chs[i])) < map.get(String.valueOf(chs[i + 1]))) {
                count -= map.get(String.valueOf(chs[i]));
            } else {
                count += map.get(String.valueOf(chs[i]));
            }
        }
        count += map.get(String.valueOf(chs[chs.length - 1]));
        return count;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
    }
}
