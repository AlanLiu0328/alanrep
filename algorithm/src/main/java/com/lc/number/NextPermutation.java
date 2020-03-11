package com.lc.number;

import com.lc.util.Utils;

/**
 * 31. 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * <p>
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * <p>
 * 必须原地修改，只允许使用额外常数空间。
 * <p>
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
public class NextPermutation {
    public static void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) return;
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] >= nums[i - 1]) {
                int index = len - 1;
                while (nums[index] <= nums[i - 1]) index--;
                swap(nums, i - 1, index);
                reverse(nums, i, len - 1);
                return;
            }
        }
        reverse(nums, 0, len - 1);
    }

    public static void reverse(int[] arr, int p1, int p2) {
        while (p1 < p2) {
            swap(arr, p1, p2);
            p1++;
            p2--;
        }
    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
