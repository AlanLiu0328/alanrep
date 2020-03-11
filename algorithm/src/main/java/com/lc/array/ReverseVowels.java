package com.lc.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 345
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 */
public class ReverseVowels {
    public static String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        int p1 = 0;
        int p2 = chars.length - 1;
        while (p1 < p2) {
            while (p1 < p2 && !check(chars[p1])) p1++;
            while (p1 < p2 && !check(chars[p2])) p2--;
            char tmp = chars[p1];
            chars[p1] = chars[p2];
            chars[p2] = tmp;
            p1++;
            p2--;
        }

        return new String(chars);
    }

    public static boolean check(char c) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        if (set.contains(c)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "Aa";
        String newStr = reverseVowels(s);
        for (char c : newStr.toCharArray()) {
            System.out.print(c);
        }
    }
}
