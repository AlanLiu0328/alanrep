package com.lc.dynamic.gupiao;

/**
 * 121
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

/**
 * dp[i][k][0] = MAX:  dp[i-1][k][0]     dp[i-1][k][1]+price[i]
 * dp[i][k][1] = MAX:  dp[i-1][k][1]     dp[i-1][k-1][0]-price[i]
 * <p>
 * dp[-1][k][0]=0
 * dp[-1][k][1]=-无穷
 * dp[i][0][0]=0
 * dp[i][0][1]=-无穷
 * <p>
 * dp[i][1][0] = MAX:  dp[i-1][1][0]    dp[i-1][1][1]+price[i]
 * dp[i][1][1] = MAX:  dp[i-1][1][1]    ( dp[i-1][0][0]) -price[i]
 */
public class Gupiao1 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[][] dp = new int[len][2];

        for (int i = 0; i < len; i++) {
            if (i == 0) {
                // dp[0][0] = Math.max(dp[-1][0] (0) , dp[-1][1]  (-无穷) + prices[0]);
                dp[i][0] = 0;
                // dp[0][1] = Math.max(dp[-1][1]  (-无穷), -prices[0])
                dp[i][1] = -prices[i];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }
        return dp[len - 1][0];
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }

        return dp_i_0;
    }

}














