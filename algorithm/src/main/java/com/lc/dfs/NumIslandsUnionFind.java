package com.lc.dfs;

import java.util.HashSet;
import java.util.Set;

public class NumIslandsUnionFind {
    private static int height;
    private static int width;
    private static int count;
    private static int[] parent;
    private static Set<Integer> set;

    public static int numIslands(char[][] grid) {
        height = grid.length;
        if (height == 0) return 0;
        width = grid[0].length;
        count = 0;
        parent = new int[height * width];
        set = new HashSet<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '1') {
                    parent[i * width + j] = i * width + j;
                } else {
                    parent[i * width + j] = -1;
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == '0') continue;
                grid[i][j] = '0';
                if (j + 1 < width && grid[i][j + 1] == '1') {
                    union(i * width + j, i * width + j + 1);
                }
                if (i + 1 < height && grid[i + 1][j] == '1') {
                    union(i * width + j, (i + 1) * width + j);
                }
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int index = i * width + j;
                if (parent[index] == -1) continue;
                parent[index] = find(index);
                if (!set.contains(parent[index])) {
                    set.add(parent[index]);
                    count++;
                }
            }
        }
        return count;
    }


    public static int find(int n) {
        while (parent[n] != n) n = parent[n];
        return n;
    }

    public static void union(int v, int w) {
        int vRoot = find(v);
        int wRoot = find(w);
        if (vRoot != wRoot) {
            parent[vRoot] = wRoot;
        }
    }
    //[["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]

    public static void main(String[] args) {
        char[][] arr = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(numIslands(arr));
    }
}
