package com.lc.sort;

import com.lc.util.Utils;

import java.util.Arrays;

/**
 * 插入排序。
 */
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[j + 1]) {
                    Utils.swap(arr, j, j + 1);
                }else {
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] arr = {4,7,1,2,6,5,3};
        insertionSort(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
