package com.lc.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class FindKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> n2 - n1);
        Arrays.stream(nums).forEach(e -> queue.add(new Integer(e)));
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.poll();
    }


    public static int findKthLargest2(int[] nums, int k) {
        int target = nums.length - k;
        int left = 0, right = nums.length - 1;
        int index = 0;
        while (true) {
            index = quickSort(nums, left, right);
            if (index == target) {
                return nums[index];
            }
            if (index < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
    }

    /**
     * 返回中间值的下标
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public static int quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }
        int tag = arr[left];
        while (left < right) {
            while (arr[left] < tag && left < right) {
                left++;
            }
            while (arr[right] > tag && left < right) {
                right--;
            }
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
        }
        return left;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{3, 14, 2, 5, 76, 9, 4, 53, 23};
        System.out.println(findKthLargest2(arr, 1));
    }
}
