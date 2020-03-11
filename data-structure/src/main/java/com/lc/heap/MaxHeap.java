package com.lc.heap;

import com.lc.array.Array;

public class MaxHeap<E extends Comparable<E>> {
    private int[] data;
    private int size;

    public MaxHeap(int capacity) {
        this.data = new int[capacity];
    }

    public MaxHeap(int[] arr) {
        this.data = arr;
        this.size = arr.length;
    }

    public MaxHeap() {
        this.data = new int[]{};
    }

    public void add(int num) {

    }


    public int size() {
        return data.length;
    }

    public boolean isEmpty() {
        return data.length == 0;
    }

    private int parent(int index) {
        if (index == 0) throw new IllegalArgumentException("index 0 does'nt have parent.");
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
