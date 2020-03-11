package com.lc.sort;

import com.lc.util.Utils;

import java.util.Arrays;

public class QuickSortNew {

    public static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        //  arr[left+1...l) <=tag         arr(r...right] >=tag
        int tag = arr[left];
        int l = left + 1, r = right;
        while (l < r) {
            while (l < r && arr[l] < tag) l++;
            while (l < r && arr[r] > tag) r--;
            if (l > r) break;
            Utils.swap(arr, l, r);
            l++;
            r--;
        }
        Utils.swap(arr, left, l - 1);

        quickSort(arr, left, l - 2);
        quickSort(arr, l, right);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 7, 7, 1, 9, 1, 5, 3};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
