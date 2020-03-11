package com.lc.dynamic;

import com.lc.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Rob3 {
    private Map<TreeNode, Integer> map = new HashMap<>();

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }

        int money = root.val;
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }
        int result = Math.max(money, rob(root.left) + rob(root.right));
        map.put(root, result);
        return result;
    }

    // 背包， 0表示不用当前，
    public int rob2(TreeNode root) {
        int[] help = help(root);
        return Math.max(help[0], help[1]);
    }

    public int[] help(TreeNode root) {
        int[] result = new int[2];
        if (root == null) return result;
        int[] left = help(root.left);
        int[] right = help(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = root.val + left[0] + right[0];
        return result;
    }
}
