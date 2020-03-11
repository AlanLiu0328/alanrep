package com.lc.tree;

import com.lc.util.TreeNode;
import com.lc.util.Utils;

import java.util.LinkedList;
import java.util.List;

/**
 * 101
 * 给定一个二叉树，检查它是否是镜像对称的。
 */
public class IsSymmetric {
    public static boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public static boolean isMirror(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) return true;
        if (r1 == null || r2 == null) return false;
        return isMirror(r1.left, r2.right) && isMirror(r1.right, r2.left) && r1.val == r2.val;
    }

    public static void main(String[] args) {
        TreeNode tree = Utils.createTree(new Integer[]{2, 3, 3, 4, 5, null, 4}, 0);
        System.out.println(isSymmetric(tree));
    }
}
