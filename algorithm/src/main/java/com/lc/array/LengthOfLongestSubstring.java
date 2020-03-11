package com.lc.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 3
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class LengthOfLongestSubstring {
    private static Map<Character, Integer> map = new HashMap<>();

    public static int lengthOfLongestSubstring(String s) {
        char[] chs = s.toCharArray();
        int p1 = 0, p2 = 0;
        int max = 0;
        int count = 0;
        while (p1 <= p2 && p2 < s.length()) {
            Integer index = map.get(chs[p2]);
            if (index == null || index < p1) {
                count++;
            } else {
                count = p2 - p1;
                max = Math.max(max, count);
                p1 = index + 1;
            }
            map.put(chs[p2], p2);
            p2++;
        }
        return max;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int max = 0;
        int p1 = 0, p2 = 0;
        char[] chs = s.toCharArray();

        while (p1 <= p2 && p2 < s.length()) {
            if (map.containsKey(chs[p2])) {
                p1 = Math.max(p1, map.get(chs[p2]) + 1);
            }
            max = Math.max(max, p2 - p1+1);
            map.put(chs[p2], p2);
            p2++;
        }
        return max;
    }

    public static void main(String[] args) {
        String str = "bbbbb";
        System.out.println(lengthOfLongestSubstring2(str));
    }
}
