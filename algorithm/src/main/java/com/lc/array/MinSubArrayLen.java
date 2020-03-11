package com.lc.array;

/**
 * 209
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 */
public class MinSubArrayLen {
    public static int minSubArrayLen(int s, int[] nums) {
        int p1 = 0, p2 = 0;
        int result = Integer.MAX_VALUE;

        while (p1 <= p2 && p2 < nums.length) {
            if (getSum(nums, p1, p2) >= s) {
                result = Math.min(result, p2 - p1 + 1);
                p1++;
            } else {
                p2++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static int getSum(int[] nums, int p1, int p2) {
        int sum = 0;
        for (int i = p1; i <= p2; i++) {
            sum += nums[i];
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr));
    }
}
