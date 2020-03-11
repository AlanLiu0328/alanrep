package com.lc.sort;

import com.lc.util.Utils;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int tag = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < arr[left]) {
                Utils.swap(arr, i, tag + 1);
                tag++;
            }
        }
        Utils.swap(arr, left, tag);
        quickSort(arr, left, tag - 1);
        quickSort(arr, tag + 1, right);
    }


    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 2, 7,7,1 ,9, 1, 5, 8, 3};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
