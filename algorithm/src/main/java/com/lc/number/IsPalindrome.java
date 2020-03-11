package com.lc.number;

/**
 * 9 回文数
 */
public class IsPalindrome {
    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;
        int y = x;
        int len = 0;
        while (y != 0) {
            y /= 10;
            len++;
        }

        int n1 = 0, n2 = 0;

        int count = len / 2;
        while (count > 0) {
            int m = x % 10;
            x /= 10;
            n2 = 10 * n2 + m;
            count--;
        }

        if (len % 2 == 1) {
            x /= 10;
        }
        n1 = x;

        return n1 == n2;
    }

    public static void main(String[] args) {
        isPalindrome(1234);
    }
}
