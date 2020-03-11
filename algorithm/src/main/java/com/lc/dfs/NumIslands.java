package com.lc.dfs;

public class NumIslands {
    private static int height;
    private static int width;
    private static int count;

    public static int numIslands(char[][] grid) {
        height = grid.length;
        if (height == 0) return 0;
        width = grid[0].length;

        count = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    public static void dfs(char[][] grid, int row, int col) {
        if (grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        if (col + 1 < width) {
            dfs(grid, row, col + 1);
        }
        if (col - 1 >= 0) {
            dfs(grid, row, col - 1);
        }
        if (row + 1 < height) {
            dfs(grid, row + 1, col);
        }
        if (row - 1 >= 0) {
            dfs(grid, row - 1, col);
        }
    }
    //[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]

    public static void main(String[] args) {
        char[][] arr = {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
        System.out.println(numIslands(arr));
    }
}
