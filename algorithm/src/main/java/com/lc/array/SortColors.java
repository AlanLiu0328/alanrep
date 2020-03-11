package com.lc.array;

import java.util.Arrays;

/**
 * 75
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColors {
    public static void sortColors(int[] nums) {
        int lTag = -1;
        int rTag = nums.length;
        for (int i = 0; i < rTag; i++) {
            if (nums[i] == 0) {
                int tmp = nums[lTag+1];
                nums[lTag+1] = nums[i];
                nums[i] = tmp;
                lTag++;
            } else if (nums[i] == 2) {
                int tmp = nums[rTag-1];
                nums[rTag-1] = nums[i];
                nums[i] = tmp;
                rTag--;
                i--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,0,1,0,1,0,0,1,2,1,0,2};
        sortColors(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
