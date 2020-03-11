package com.lc.niukewang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Shuzigeshu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = in.nextInt();
                int m = 1;
                if (map.containsKey(num)) {
                    m = map.get(num) + 1;
                }
                map.put(num, m);
            }
            boolean flag = true;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() > n / 2) {
                    System.out.println(entry.getKey());
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                System.out.println(-1);
            }
        }
    }
}
