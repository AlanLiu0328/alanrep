package com.lc.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 16. 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums, int target) {
        if (nums == null | nums.length < 3) return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        List<Integer> arr = null;

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int p1 = i + 1, p2 = nums.length - 1;
            while (p1 < p2) {
                int sum = Math.abs(nums[p1] + nums[p2] + nums[i] - target);
                if (sum < min) {
                    min = sum;
                    arr = new ArrayList<>(Arrays.asList(nums[i], nums[p1], nums[p2]));
                }
                if ((nums[p1] + nums[p2]) == target - nums[i]) {
                    return nums[p1] + nums[p2] + nums[i];
                }
                if ((nums[p1] + nums[p2]) > target - nums[i]) {
                    while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                    p2--;
                } else if ((nums[p1] + nums[p2]) < target - nums[i]) {
                    while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                    p1++;
                }
            }
        }
        int result = 0;
        for (Integer integer : arr) {
            result += integer;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        System.out.println(threeSumClosest(arr, 1));
    }
}
