package com.lc.dynamic;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 120
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/triangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumTotal {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int width = triangle.get(height - 1).size();
        int[][] dp = new int[height + 1][width + 1];

        for (int i = 0; i <= width; i++) {
            dp[height][i] = 0;
        }

        for (int i = height - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        List<Integer> l1 = new LinkedList<>(Arrays.asList(2));
        List<Integer> l2 = new LinkedList<>(Arrays.asList(3,4));
        List<Integer> l3 = new LinkedList<>(Arrays.asList(6,5,7));
        List<Integer> l4= new LinkedList<>(Arrays.asList(4,1,8,3));
        List<List<Integer>> list = new LinkedList<>();
        list.addAll(Arrays.asList(l1,l2,l3,l4));
        System.out.println(minimumTotal(list));
    }
}
