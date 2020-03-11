package com.lc.sort;

import com.lc.util.Utils;

import java.util.Arrays;

public class QuickSort3Ways {
    public static void quickSort(int[] arr, int left, int right) {
        //  arr[left+1,l]< target          arr(l,i)=target  arr(r,right] >target
        if (left >= right) return;
        int tag = arr[left];
        int l = left, r = right, i = left + 1;
        while (i <= r) {
            if (arr[i] < tag) {
                Utils.swap(arr, l + 1, i);
                l++;
                i++;
            } else if (arr[i] > tag) {
                Utils.swap(arr, i, r);
                r--;
            } else {
                i++;
            }
        }
        Utils.swap(arr, left, l);
        quickSort(arr,left,l-1);
        quickSort(arr,r+1,right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 6, 7, 7, 1, 9, 1, 5, 3};
        quickSort(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::print);
    }
}
