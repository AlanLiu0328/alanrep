package com.lc.dynamic;

/**
 * 152
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        int max = Integer.MIN_VALUE;

        dp[0][0] = 1;
        dp[0][1] = 1;

        for (int i = 1; i < n + 1; i++) {
            if (nums[i - 1] > 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i - 1], nums[i - 1]);
                dp[i][1] = Math.min(dp[i - 1][1] * nums[i - 1], nums[i - 1]);
            } else {
                dp[i][0] = Math.max(dp[i - 1][1] * nums[i - 1], nums[i - 1]);
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i - 1], nums[i - 1]);
            }
            max = Math.max(max, dp[i][0]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 2};
        System.out.println(maxProduct(arr));
    }
}
