package com.lc.dynamic.package01;

/**
 * 递归记忆化
 */
public class KnapSack01 {
    private static int[][] memo;

    public static int knapsack01(int[] w, int[] v, int c) {
        int n = w.length;
        memo = new int[n + 1][c + 1];
        return bestValue(w, v, n - 1, c);
    }


    private static int bestValue(int[] w, int[] v, int i, int c) {
        if (i < 0 || c <= 0) {
            return 0;
        }
        if (memo[i][c] != 0) {
            return memo[i][c];
        }
        int result = bestValue(w, v, i - 1, c);
        if (c > -w[i]) {
            result = Math.max(result, v[i] + bestValue(w, v, i - 1, c - w[i]));
        }
        memo[i][c] = result;
        return result;
    }


}


























