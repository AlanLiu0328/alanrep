package com.lc.array;

import java.util.Arrays;

/**
 * 88
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);

    }

    /**
     * 使用nums1空闲的结尾
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[end] = nums1[p1];
                p1--;
            } else {
                nums1[end] = nums2[p2];
                p2--;
            }
            end--;
        }
        if (p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 2, 3, 5, 7, 0, 0, 0, 0};
        int[] nums2 = new int[]{3, 4, 5, 9};
        merge2(nums1, 5, nums2, 4);
        Arrays.stream(nums1).forEach(System.out::print);

    }
}
