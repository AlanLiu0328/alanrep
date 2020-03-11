package com.lc.collection;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 220
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contains-duplicate-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainsNearbyAlmostDuplicate {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = set.ceiling(nums[i]);
            if (ceiling != null && ceiling <= nums[i] + t) return true;
            Integer floor = set.floor(nums[i]);
            if (floor != null && nums[i] <= floor + t) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;

        /**
         *     TreeSet<Integer> set = new TreeSet<>();
         *     for (int i = 0; i < nums.length; i++) {
         *         Integer s = set.ceiling(nums[i]);
         *         if (s != null && s <= nums[i] + t) return true;
         *
         *         Integer g = set.floor(nums[i]);
         *         if (g != null && nums[i] <= g + t) return true;
         *
         *         set.add(nums[i]);
         *         if (set.size() > k) {
         *             set.remove(nums[i - k]);
         *         }
         *     }
         *     return false;
         *
         */
    }

    public static void main(String[] args) {
        int[] arr = {-1, 2147483647};
        System.out.println(containsNearbyAlmostDuplicate(arr, 1, 2147483647));
    }
}
