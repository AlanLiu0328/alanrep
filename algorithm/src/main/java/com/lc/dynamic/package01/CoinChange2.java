package com.lc.dynamic.package01;

import java.util.HashMap;
import java.util.Map;

/**
 * 322
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-change
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CoinChange2 {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (map.containsKey(amount)) {
            return map.get(amount);
        }

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int i = coinChange(coins, amount - coin);
            if (i == -1) {
                continue;
            } else {
                res = Math.min(res, i + 1);
            }
        }
        if (res != -1) {
            map.put(amount, res);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,5};
        System.out.println(coinChange(arr, 11));
    }
}
