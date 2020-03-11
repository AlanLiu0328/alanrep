package com.lc.array;

import java.util.Arrays;

/**
 * 26
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int s = 0;
        int f = 1;
        while (f < nums.length) {
            if (nums[f] != nums[s]) {
                s++;
                nums[s] = nums[f];
            }
            f++;
        }
        return s + 1;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 4, 4, 5, 6, 7};
        int i = removeDuplicates(arr);
        System.out.println(i);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
