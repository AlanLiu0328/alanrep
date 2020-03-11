package com.lc.array;

public class BinarySearch {

    public static int binarySearch(int arr[], int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
//            int mid = (left + right) / 2; //可能会越界
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int index = binarySearch(new int[]{1, 3, 5, 6, 7, 9, 13, 15, 16,}, 9);
        System.out.println(index);
    }
}
