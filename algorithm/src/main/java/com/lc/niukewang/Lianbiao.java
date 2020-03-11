package com.lc.niukewang;

import java.util.Scanner;

public class Lianbiao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int len = in.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = in.nextInt();
            }
            int num = in.nextInt();

            for (int n : arr) {
                if (n!=num){
                    System.out.print(n+" ");
                }
            }
            System.out.println();
        }

    }

}
