package com.lc.dynamic.package01;

/**
 * 416
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 注意:
 * <p>
 * 每个数组中的元素不会超过 100
 * 数组的大小不会超过 200
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartition {
    static int[][] dp;

    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;

        dp = new int[n][sum + 1];
        return help(nums, n - 1, sum);
    }

    public static boolean help(int[] nums, int index, int sum) {
        if (sum < 0 || index < 0) {
            return false;
        }
        if (dp[index][sum] != 0) {
            return dp[index][sum] == 1 ? true : false;
        }
        if (sum == 0) {
            return true;
        }

        boolean result = help(nums, index - 1, sum) || help(nums, index - 1, sum - nums[index]);
        dp[index][sum] = result ? 1 : -1;
        return result;
    }

    public static boolean canPartition2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        for (int i = 0; i <= sum; i++) {
            dp[i] = nums[0] == i;
        }
        for (int i = 1; i < n; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        return dp[sum];
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(canPartition2(arr));
    }
}
