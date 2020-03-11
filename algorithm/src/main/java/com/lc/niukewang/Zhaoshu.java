package com.lc.niukewang;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 给定一个整型数组arr，找到其中最小的k个数。
 * 输入描述:
 * 输入包含两行，第一行包含两个整数n和k(1 \leq k \leq n \leq 10^5)(1≤k≤n≤10
 * 5
 * )，代表数组arr的长度，第二行包含n个整数，代表数组arr(1 \leq arr_i \leq 10^9)(1≤arr
 * i
 * ​
 * ≤10
 * 9
 * )。
 * 输出描述:
 * 输出包含一行，k个整数，代表数组中最小的k个整数。
 */
public class Zhaoshu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int len = in.nextInt();
            int resLen = in.nextInt();
            int[] arr1 = new int[len];
            int[] arr2 = new int[len];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                int num = in.nextInt();
                arr1[i] = num;
                arr2[i] = num;
            }
            Arrays.sort(arr1);
            for (int i = 0; i < resLen; i++) {
                map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
            }

            for (int i = 0; i < arr2.length; i++) {
                if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
                    map.put(arr2[i], map.get(arr2[i]) - 1);
                    System.out.print(arr2[i] + " ");
                    continue;
                }
            }
            System.out.println();
        }
    }
}
