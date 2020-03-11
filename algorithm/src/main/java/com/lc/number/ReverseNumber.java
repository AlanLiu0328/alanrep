package com.lc.number;

public class ReverseNumber {
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int m = x % 10;
            x = x / 10;
            if (result > Integer.MAX_VALUE / 10 || result == Integer.MAX_VALUE / 10 && m > 7) return 0;
            if (result < Integer.MIN_VALUE / 10 || result == Integer.MIN_VALUE / 10 && m > 8) return 0;
            result = 10 * result + m;
        }
        return result;
    }

    public static void main(String[] args) {
        reverse(123);
    }

}
