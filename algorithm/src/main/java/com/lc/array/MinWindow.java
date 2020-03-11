package com.lc.array;

/**
 * ************************会超时
 * 76
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * <p>
 * 示例：
 * <p>
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {
    public static String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int p1 = 0, p2 = 0;
        int min = Integer.MAX_VALUE;
        String result = "";
        while (p1 <= p2 && p2 < s.length()) {
            if (check(s.substring(p1, p2 + 1), t)) {
                while (check(s.substring(p1, p2 + 1), t)) {
                    p1++;
                }
                if (min > p2 - p1 + 2) {
                    min = p2 - p1 + 2;
                    result = s.substring(p1 - 1, p2 + 1);
                }
            }
            p2++;
        }
        return result;
    }

    public static boolean check(String s, String t) {
        if (t.length() > s.length()) {
            return false;
        }
        char[] chs = t.toCharArray();
        String src = s;
        for (char c : chs) {
            if (src.indexOf(c) == -1) {
                return false;
            } else {
                src = src.replaceFirst(String.valueOf(c), "-");
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = minWindow("cabwefgewcwaefgcf", "cae");
        System.out.println(s);
    }
}
