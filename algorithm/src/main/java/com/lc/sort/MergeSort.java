package com.lc.sort;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        mergeTwoArrays(arr, left, mid + 1, right);
    }


    public static void mergeTwoArrays(int[] arr, int left, int mid, int right) {
        int[] newArr = new int[arr.length];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        int p = left;
        int p1 = left, p2 = mid;
        while (p1 < mid && p2 <= right) {
            if (newArr[p1] < newArr[p2]) {
                arr[p] = newArr[p1];
                p1++;
            } else {
                arr[p] = newArr[p2];
                p2++;
            }
            p++;
        }
        if (p1 < mid) {
            System.arraycopy(newArr, p1, arr, p, mid - p1);
        } else {
            System.arraycopy(newArr, p2, arr, p, right - p2+1);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 2, 7, 9, 1, 5, 8, 3};
        mergeSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
