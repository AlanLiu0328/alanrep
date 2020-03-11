package com.lc.niukewang;

import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Zhanpaixu {
    /*public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();

            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                stack.add(in.nextInt());
            }
            stack.sort(null);
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        }

    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            Stack<Integer> s1 = new Stack<>();
            in.nextLine();
            String line = in.nextLine();
            String[] strs = line.split(" ");
            for (int i = strs.length - 1; i >= 0; i--) {
                s1.push(Integer.parseInt(strs[i]));
            }
            sortStack(s1);
            while (!s1.isEmpty()) {
                System.out.print(s1.pop() + " ");
            }
            System.out.println();
        }
    }

    public static void sortStack(Stack<Integer> s) {
        Stack<Integer> s2 = new Stack<>();
        while (!s.isEmpty()) {
            int tmp = s.pop();
            while (!s2.isEmpty() && tmp > s2.peek()) {
                s.push(s2.pop());
            }
            s2.push(tmp);
        }
        while (!s2.isEmpty()) {
            s.push(s2.pop());
        }
    }
}
