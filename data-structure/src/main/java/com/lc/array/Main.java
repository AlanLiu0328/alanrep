package com.lc.array;

public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }

        arr.add(1, 100);
        arr.addFirst(-1);
        arr.removeFirst();
        arr.removeFirst();
        arr.removeFirst();
        System.out.println(arr);

    }
}
