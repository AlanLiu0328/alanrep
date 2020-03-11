package com.lc.niukewang;

import java.util.Scanner;

public class Chafenshu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] score = new int[n];
            for (int i = 0; i < n; i++) {
                score[i] = in.nextInt();
            }
            in.nextLine();
            for (int i = 0; i < m; i++) {
                String str = in.nextLine();
                String[] strs = str.split(" ");
                int num1 = Integer.parseInt(strs[1]);
                int num2 = Integer.parseInt(strs[2]);
                if ("Q".equals(strs[0])) {
                    int max = 0;
                    if (num1 > num2) {
                        num1 = num1 + num2;
                        num2 = num1 - num2;
                        num1 = num1 - num2;
                    }
                    for (int j = num1 - 1; j <= num2 - 1; j++) {
                        max = Math.max(max, score[j]);
                    }
                    System.out.println(max);
                } else if ("U".equals(strs[0])) {
                    score[num1 - 1] = num2;
                }
            }
        }

    }
}
