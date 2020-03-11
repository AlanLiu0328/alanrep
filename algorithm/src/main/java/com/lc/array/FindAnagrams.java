package com.lc.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 438
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * <p>
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagrams {
    private static int[] sAarr;
    private static int[] pArr;

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int[] pArr = createArr(p);
        for (int i = 0; i <= s.length() - p.length(); i++) {
            int[] sArr = createArr(s.substring(i, i + p.length()));
            if (checkArr(sArr, pArr)) {
                list.add(i);            }
        }
        return list;
    }

    public static int[] createArr(String s) {
        char[] chs = s.toCharArray();
        int[] arr = new int[26];
        for (char ch : chs) {
            arr[ch - 'a']++;
        }
        return arr;
    }

    public static boolean checkArr(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //s: "cbaebabacd" p: "abc"
        String s = "abab";
        String p = "ab";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }
}
