package com.lc.string;

/**
 * 5 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 */
public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        if (s == null || "".equals(s)) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String max = "";
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) != s.charAt(j)) continue;
                if (i == j || j == i + 1) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = dp[i + 1][j - 1];
                }
                if (dp[i][j] && j - i + 1 > max.length()) {
                    max = s.substring(i, j + 1);
                }
            }
        }
        return max;
    }

    public static String longestPalindrome2(String s) {
        if (s == null || "".equals(s)) return "";
        int len = s.length();

        int max = 0;
        String result = "";
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    if (j - i + 1 > max) {
                        max = j - i + 1;
                        result = s.substring(i, j + 1);
                    }
                }
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        if (s.equals(s2)) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "abcba";
        String s1 = longestPalindrome(s);
        System.out.println(s1);
    }
}
