package com.lc.string;

import java.util.Scanner;

public class PrintString {
    public static void printString() {
        Scanner in = new Scanner(System.in);
        String str = null;
        while ((str = in.nextLine()) != null) {
            while (str.length() > 8) {
                String s = str.substring(0, 8);
                System.out.println(s);
                str = str.substring(8, str.length());
            }
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < 8 - str.length(); i++) {
                sb.append('0');
            }
            System.out.println(sb.toString());
        }
    }

    public static void main(String[] args) {
        printString();
    }
}
