package com.lc.array;

import java.util.*;

/**
 * 80
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicates2 {
    private static Set<Integer> set = new HashSet<>();

    public static int removeDuplicates(int[] arr) {
        int s = 0;
        int f = 1;
        while (f < arr.length) {

            if ((arr[f] != arr[s]) || (arr[f] == arr[s]) && (!set.contains(arr[s]))) {
                if (arr[f] == arr[s]) {
                    set.add(arr[s]);
                }
                s++;
                arr[s] = arr[f];

            }
            f++;
        }
        return s + 1;
    }

    public static int removeDuplicates2(int[] arr) {
        int s = 0;
        int f = 1;
        int count = 1;
        while (f < arr.length) {
            if (arr[f] == arr[f - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count <= 2) {
                arr[++s] = arr[f];
            }
            f++;
        }
        return s + 1;
    }

    public static int removeDuplicates3(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 2, 2, 2, 2, 2, 3, 3, 4, 4, 4, 5, 6, 7};
        int i = removeDuplicates3(arr);
        System.out.println(i);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
