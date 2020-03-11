package com.lc.niukewang;

import java.util.Scanner;

public class Qishui {


    public static void help(int n) {
        int count = 0;
        while (n >= 3) {
            int he = n / 3;
            int sh = n % 3;
            n = sh + he;
            count += he;
        }
        if (n==2){
            count++;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            int n = in.nextInt();
            if (n == 0) return;
            help(n);
        }
    }
}
