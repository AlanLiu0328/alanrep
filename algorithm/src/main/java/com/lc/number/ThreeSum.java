package com.lc.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 15. 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null | nums.length < 3) return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int p1 = i + 1, p2 = nums.length - 1;
            while (p1 < p2) {
                if (p1 > i + 2 && nums[p1] == nums[p1 - 1]) {
                    p1++;
                    continue;
                }
                if (p2 < nums.length - 1 && nums[p2] == nums[p2 + 1]) {
                    p2--;
                    continue;
                }
                if ((nums[p1] + nums[p2]) == nums[i] * -1) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i], nums[p1], nums[p2])));
                    p1++;
                    p2--;
                } else if ((nums[p1] + nums[p2]) > nums[i] * -1) {
                    p2--;
                } else {
                    p1++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4, -1, -1, 0, 1, 2};
        System.out.println(threeSum(arr));
    }
}
