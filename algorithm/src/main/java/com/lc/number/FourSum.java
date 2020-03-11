package com.lc.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < len - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int p1 = j + 1, p2 = len - 1;
                while (p1 < p2) {
                    if (nums[i] + nums[j] + nums[p1] + nums[p2] == target) {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[p1], nums[p2])));
                        while (p1 < p2 && nums[p1] == nums[p1 + 1]) p1++;
                        p1++;
                        while (p1 < p2 && nums[p2] == nums[p2 - 1]) p2--;
                        p2--;
                    } else if (nums[i] + nums[j] + nums[p1] + nums[p2] > target) {
                        p2--;
                    } else {
                        p1++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-3, -2, -1, 0, 0, 1, 2, 3};
        System.out.println(fourSum(arr, 0));
    }
}
