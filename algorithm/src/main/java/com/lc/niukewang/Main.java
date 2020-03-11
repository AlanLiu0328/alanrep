package com.lc.niukewang;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        while (in.hasNext()) {
            int n = in.nextInt();
            int[][] dp = new int[n + 1][2];
            dp[1][0] = 1;
            dp[1][1] = 0;
            dp[2][0] = 1;
            dp[2][1] = 1;
            dp[3][0] = 1;
            dp[3][1] = 2;
            dp[4][0] = 1;
            dp[4][1] = 3;

            for (int i = 5; i <= n; i++) {
                dp[i][0] = dp[i - 1][0] + dp[i - 3][0];
                dp[i][1] = dp[i][0] + dp[i - 1][0] + dp[i - 2][0];
            }

            System.out.println((dp[n][0] + dp[n][1]) % 1000000007);
        }
    }
}