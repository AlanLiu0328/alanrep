package com.lc.dynamic;

import java.util.HashSet;
import java.util.Set;

public class Fibonacci {
    private static int[] dp = new int[1024];

    static {
        dp[1] = 1;
        dp[2] = 1;
    }

    public static int fibonacci(int num) {
        if (num == 1 || num == 2) {
            return 1;
        }

        if (dp[num] == 0) {
            dp[num] = fibonacci(num - 1) + fibonacci(num - 2);
        }

       return dp[num];

    }

    public static void main(String[] args) {
        System.out.println(fibonacci(500));
    }
}
