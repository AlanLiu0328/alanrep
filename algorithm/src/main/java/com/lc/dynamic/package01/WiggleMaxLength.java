package com.lc.dynamic.package01;

/**
 * 376
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * <p>
 * 例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * <p>
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/wiggle-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class WiggleMaxLength {
    public static int wiggleMaxLength(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                nums[i] = 1;
            } else {
                nums[i] = -1;
            }
        }
        nums[0] = 0;

        int max = 0;
        int sum = 0;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (Math.abs(sum) == 2) {
                cur = 1;
            } else {
                cur++;
                max = Math.max(max, cur);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,17,5,10,13,15,10,5,16,8};
        System.out.println(wiggleMaxLength(arr));
    }
}
