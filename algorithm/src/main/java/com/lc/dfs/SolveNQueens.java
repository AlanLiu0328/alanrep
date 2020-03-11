package com.lc.dfs;

import java.util.*;

/**
 * 51
 * N皇后
 */
public class SolveNQueens {
    private static Set<Integer> col;
    private static Set<Integer> pie;
    private static Set<Integer> na;
    private static List<List<String>> result;
    private static int n;

    public static List<List<String>> solveNQueens(int num) {
        col = new HashSet<>();
        pie = new HashSet<>();
        na = new HashSet<>();
        n = num;
        result = new LinkedList<>();
        LinkedList<String> cur_state = new LinkedList<>();
        help(0, cur_state);

        return result;
    }

    public static void help(int row, LinkedList<String> cur_state) {
        if (row >= n) {
            result.add(new LinkedList<>(cur_state));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !pie.contains(i + row) && !na.contains(i - row)) {
                col.add(i);
                pie.add(i + row);
                na.add(i - row);
                cur_state.add(num2String(i));
                help(row + 1, cur_state);
                col.remove(i);
                pie.remove(i + row);
                na.remove(i - row);
                cur_state.removeLast();
            }
        }
    }

    public static String num2String(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (num == i) {
                sb.append("Q");
            } else {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(solveNQueens(8));
    }
}
