package com.lc.niukewang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定数组arr，arr中所有的值都为正整数且不重复。每个值代表一种面值的货币，每种面值的货币可以使用任意张，再给定一个aim，代表要找的钱数，求组成aim的最少货币数。
 * 输入
 * 复制
 * 3 20
 * 5 2 3
 * 输出
 * 复制
 * 4
 */
public class Zuixiaohuobi {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int m = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = in.nextInt();
            }
            int[] dp = new int[n + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;
            for (int i = 1; i <= n; i++) {
                int count = Integer.MAX_VALUE;
                for (int q : arr) {
                    if (i >= q && dp[i - q] != -1) {
                        count = Math.min(count, dp[i - q] + 1);
                    }
                }
                dp[i] = count == Integer.MAX_VALUE ? -1 : count;
            }
            System.out.println(dp[n]);
        }
    }

}
