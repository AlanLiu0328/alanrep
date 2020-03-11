package com.lc.heap;

import com.lc.util.Utils;

public class MaxHeap {
    private int[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        data = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public MaxHeap(int[] arr) {
        data = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            data[i + 1] = arr[i];
        }
        count = arr.length;
        capacity = arr.length;

        for (int i = count / 2; i >= 1; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int item) {
        data[count + 1] = item;
        count++;

        shiftUp(count);
    }

    public int extractMax() {
        int result = data[1];
        Utils.swap(data, 1, count);
        count--;
        shiftDown(1);
        return result;
    }

    public void shiftDown(int k) {

        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1] > data[j]) {
                j = j + 1;
            }
            if (data[j] > data[k]) {
                Utils.swap(data, j, k);
            }
            k = j;
        }
    }

    private void shiftUp(int k) {
        while (k > 1 && data[k / 2] < data[k]) {
            Utils.swap(data, k / 2, k);
            k /= 2;
        }
    }


    public static void main(String[] args) {
        int[] arr = {4, 32, 6, 7, 8, 2, 7, 9, 6,};
        MaxHeap maxHeap = new MaxHeap(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(maxHeap.extractMax() + " ");
        }
    }
}
