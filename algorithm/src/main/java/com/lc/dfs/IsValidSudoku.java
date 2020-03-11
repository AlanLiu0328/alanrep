package com.lc.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 36
 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-sudoku
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidSudoku {
    private static char[][] b;
    private static Set<Character>[] rows;
    private static Set<Character>[] cols;
    private static Set<Character>[] blks;
    private static boolean solved;

    public static void solveSudoku(char[][] board) {
        b = board;
        solved = false;
        rows = new HashSet[9];
        cols = new HashSet[9];
        blks = new HashSet[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            blks[i] = new HashSet<>();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (b[i][j] != '.') {
                    rows[i].add(b[i][j]);
                    cols[j].add(b[i][j]);
                    blks[i / 3 * 3 + j / 3].add(b[i][j]);
                }
            }
        }
        int[] start = findNext(0, 0);
        dfs(start[0], start[1]);
    }

    public static void dfs(int row, int col) {
        if (solved) {
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (check(row, col, i)) {
                char c = ("" + i).charAt(0);
                b[row][col] = c;
                rows[row].add(c);
                cols[col].add(c);
                blks[row / 3 * 3 + col / 3].add(c);
                int[] next = findNext(row, col);
                if (next == null) {
                    solved = true;
                    return;
                } else {
                    dfs(next[0], next[1]);
                }
                if (solved) {
                    return;
                }
                b[row][col] = '.';
                rows[row].remove(c);
                cols[col].remove(c);
                blks[row / 3 * 3 + col / 3].remove(c);
            }
        }
    }

    public static boolean check(int row, int col, int val) {
        char c = ("" + val).charAt(0);
        if (rows[row].contains(c)) {
            return false;
        }
        if (cols[col].contains(c)) {
            return false;
        }
        if (blks[row / 3 * 3 + col / 3].contains(c)) {
            return false;
        }
        return true;
    }

    public static int[] findNext(int row, int col) {
        while (b[row][col] != '.') {
            col++;
            if (col >= 9) {
                row++;
                col = 0;
            }
            if (row >= 9) {
                return null;
            }
        }
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        char[][] arr = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, {'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'}, {'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'}, {'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
        solveSudoku(arr);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
