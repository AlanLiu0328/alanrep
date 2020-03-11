package com.lc.sort;

import com.lc.util.Utils;

import java.util.Arrays;

/**
 * 选择排序，每次 找到最小的，放到左边
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;


        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            Utils.swap(arr,i,minIndex);
        }
    }

    public static void main(String[] args) {
        int[] arr = {4,7,1,2,6,5,3};
        selectionSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
