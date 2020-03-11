package com.lc.array;

/**
 * 167
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * <p>
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    public static int[] twoSum(int[] arr, int target) {
        int p1 = 0;
        int p2 = arr.length - 1;

        int[] result = new int[]{-1, -1};

        while (p1 < p2) {
            int sum = arr[p1] + arr[p2];
            if (sum == target) {
                result[0] = p1 + 1;
                result[1] = p2 + 1;
                return result;
            }
            if (sum < target) {
                p1++;
                continue;
            } else {
                p2--;
                continue;
            }
        }
        return result;
    }
}
