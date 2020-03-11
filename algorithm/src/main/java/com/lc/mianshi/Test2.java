package com.lc.mianshi;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static int maxNumberOfBalloons(String text) {
        if (text == null || text.length() < 7) return 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'b' || chars[i] == 'a' || chars[i] == 'l' || chars[i] == 'o' || chars[i] == 'n') {
                map.put(chars[i], map.getOrDefault(chars[i], 0) + 1);
            }
        }
        int count = Integer.MAX_VALUE;
        if (map.entrySet().size() != 5) return 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int curCount = 0;
            if (entry.getKey() == 'l' || entry.getKey() == 'o') {
                curCount = entry.getValue() / 2;
            } else {
                curCount = entry.getValue();
            }
            count = Math.min(curCount, count);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }
}
