package com.lc.niukewang;

import java.util.*;

public class MingSuijishu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int num = in.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < num; i++) {
                set.add(in.nextInt());
            }
            set.stream().forEach(System.out::println);
        }
    }
}
