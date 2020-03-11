package com.lc.number;

public class Divide {
    public static int divide(int dividend, int divisor) {
        boolean flag = true;
        if (divisor < 0 && dividend > 0 || divisor > 0 && dividend < 0) {
            flag = false;
        }
        divisor = Math.abs(divisor);
        dividend = Math.abs(dividend);
        int count = 0;
        while (dividend >= divisor) {
            dividend = dividend - divisor;
            count++;
        }

        return flag ? count : 0 - count;
    }

    public static void main(String[] args) {
        System.out.println(divide(-1, 1));
    }
}
