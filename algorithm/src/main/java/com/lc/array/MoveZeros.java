package com.lc.array;


import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeros {
    public static void moveZeros1(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i != count) {
                    arr[count] = arr[i];
                    arr[i] = 0;
                }
                count++;
            }


        }
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 0, 0, 1, 58, 0, 0};
        moveZeros1(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
