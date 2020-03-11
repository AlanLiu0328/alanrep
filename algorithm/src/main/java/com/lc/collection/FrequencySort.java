package com.lc.collection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 451
 * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * "tree"
 * <p>
 * 输出:
 * "eert"
 * <p>
 * 解释:
 * 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FrequencySort {

    public static String frequencySort(String s) {
        Map<Integer, StringBuilder> map = new HashMap<>();
        int[] chars = new int[256];
        for (char c : s.toCharArray()) {
            chars[c]++;
        }

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 0) continue;
            char c = (char) i;
            StringBuilder sb = new StringBuilder();
            if (map.get(chars[i]) != null) {
                sb.append(map.get(chars[i]));
            }
            for (int j = 0; j < chars[i]; j++) {
                sb.append(c);
            }
            map.put(chars[i], sb);

        }
        Integer[] keys = map.keySet().toArray(new Integer[]{});
        Arrays.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (int i = keys.length - 1; i >= 0; i--) {
            sb.append(map.get(keys[i]));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }
}
