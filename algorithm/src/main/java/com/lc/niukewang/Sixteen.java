package com.lc.niukewang;

import java.util.Scanner;

public class Sixteen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.nextLine().substring(2);
            int i = Integer.parseInt(str, 16);
            System.out.println(i);
        }

    }
}
