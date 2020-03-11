package com.lc.niukewang;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述
 * 给定一个无序数组arr，其中元素可正、可负、可0。给定一个整数k，求arr所有的子数组中累加和小于或等于k的最长子数组长度
 * 例如：arr = [3, -2, -4, 0, 6], k = -2. 相加和小于等于-2的最长子数组为{3, -2, -4, 0}，所以结果返回4
 * [要求]
 * 时间复杂度为O(n)O(n)，空间复杂度为O(n)O(n)
 */
public class Zuichangshuzu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int p1 = 0, p2 = 0;
            int sum = 0;
            int len = 0;
            while (p2 < arr.length) {
                sum += arr[p2];
                while (sum <= k && p1 > 0) {
                    sum -= arr[p1];
                    p1--;
                }
                len = Math.max(p2 - p1, len);
                if (sum > k) {
                    len = Math.max(p2 - p1, len);
                }
                while (sum > k && p1 <= p2) {
                    sum -= arr[p1];
                    p1++;
                }
                if (p1 > p2) {
                    p2 = p1;
                    sum = 0;
                }
            }
            System.out.println(len);
        }
    }
}
