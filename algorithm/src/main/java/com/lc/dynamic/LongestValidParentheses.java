package com.lc.dynamic;

/**
 * 32. 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        int max = 0;
        int left = 0, right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            }
            if (right > left) {
                left = right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left * 2);
            }
            if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }


    public static int longestValidParentheses2(String s) {
        int len = s.length();
        int[] dp = new int[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') continue;
            int r1 = 0, r2 = 0;
            if (i - 1 >= 0 && s.charAt(i - 1) == '(') {
                if (i >= 2) {
                    r1 = dp[i - 2] + 2;
                } else {
                    r1 = 2;
                }
            } else if (i > 0 && i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                r2 = dp[i - 1] + 2;
                if (i - r2 >= 0) {
                    r2 += dp[i - r2];
                }
            }
            dp[i] = Math.max(r1, r2);
        }

        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()())"));
    }
}
