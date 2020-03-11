package com.lc.dynamic;

/**
 * 91
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "12"
 * 输出: 2
 * 解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/decode-ways
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumDecodings {
    public static int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[len] = 1;
        if (s.charAt(len - 1) != '0') {
            dp[len - 1] = 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i)=='0'){
                continue;
            }
            int r2 = 0;
            int num = (s.charAt(i) - '0') * 10 + s.charAt(i + 1)-'0';
            if (num <= 26) {
                r2 = dp[i+2];
            }
            dp[i] = dp[i+1]+r2;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("101"));
    }
}
