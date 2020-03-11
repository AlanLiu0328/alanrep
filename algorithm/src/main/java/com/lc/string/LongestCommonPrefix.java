package com.lc.string;

/**
 * 14
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String result = "";
        String str = strs[0];
        int sLen = str.length();

        for (int i = 0; i < sLen; i++) {
            for (String s : strs) {
                if (i >= s.length() || s.charAt(i) != (str.charAt(i))) {
                    return result;
                }
            }
            result = str.substring(0, i + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] arr = {"aa", "a"};
        System.out.println(longestCommonPrefix(arr));
    }
}
