package com.lc.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 * <p>
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 */
public class OrangesRotting {
    public static int orangesRotting(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 2) {
                    queue.add(i * width + j);
                }
            }
        }
        queue.add(null);
        int count = 0;
        while (!queue.isEmpty()) {
            Integer e = queue.poll();
            if (e != null) {
                int row = e / width;
                int col = e % width;
                if (col + 1 < width && grid[row][col + 1] == 1) {
                    grid[row][col + 1] = 2;
                    queue.add(row * width + col + 1);
                }
                if (col - 1 >= 0 && grid[row][col - 1] == 1) {
                    grid[row][col - 1] = 2;
                    queue.add(row * width + col - 1);
                }
                if (row + 1 < height && grid[row + 1][col] == 1) {
                    grid[row + 1][col] = 2;
                    queue.add((row + 1) * width + col);
                }
                if (row - 1 >= 0 && grid[row - 1][col] == 1) {
                    grid[row - 1][col] = 2;
                    queue.add((row - 1) * width + col);
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.add(null);
                    count++;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 2}};
        System.out.println(orangesRotting(arr));
    }
}
