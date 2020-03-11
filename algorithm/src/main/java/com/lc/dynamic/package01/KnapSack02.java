package com.lc.dynamic.package01;

/**
 * 动态规划
 * 01背包，二位数组，  C+1列，N 行
 */
public class KnapSack02 {


    public static int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][c + 1];

        for (int i = 0; i < c; i++) {
            dp[0][i] = (i >= w[0] ? v[0] : 0);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (w[i] >= j) {
                    dp[i][j] = Math.max(dp[i][j], (dp[i - 1][j - w[i]] + v[i]));
                }
            }
        }
        return dp[n - 1][c];
    }


    public static int knapsack02(int[] w, int[] v, int c) {
        int n = w.length;
        if (n == 0 || c == 0) {
            return 0;
        }
        int[] dp = new int[c + 1];

        for (int i = 0; i < c; i++) {
            dp[i] = (i >= w[0] ? v[0] : 0);
        }

        for (int i = 0; i < n; i++) {
            for (int j = c; j >= 0; j--) {
                if (j >= w[n]) {
                    dp[i] = Math.max(dp[j], (v[i] + dp[j - w[i]]));
                }
            }
        }

        return dp[c];
    }

}


























