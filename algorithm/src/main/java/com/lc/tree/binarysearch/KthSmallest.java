package com.lc.tree.binarysearch;

import com.lc.util.TreeNode;
import com.lc.util.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 230
 * 给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。
 */
public class KthSmallest {
    private static List<Integer> list;

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return Integer.MIN_VALUE;
        list = new ArrayList<>();
        help(root);
        return list.get(k - 1);
    }

    public static void help(TreeNode root) {
        if (root == null) return;

        help(root.left);
        list.add(root.val);
        help(root.right);

    }

    public static int kthSmallest1(TreeNode root, int k) {
        LinkedList<TreeNode> list2 = new LinkedList<>();
        while (true) {
            while (root != null) {
                list2.add(root);
                root = root.left;
            }
            root = list2.removeLast();
            if (--k == 0) return root.val;
            root = root.right;
        }
    }

    public static int kthSmallest2(TreeNode root, int k) {
        LinkedList<TreeNode> list3 = new LinkedList<>();
        while (true) {
            while (root != null) {
                list3.add(root);
                root = root.left;
            }
            TreeNode last = list3.removeLast();
            if (--k == 0) return last.val;
            root = root.right;
        }

    }

    public static void main(String[] args) {
        String line = "1 1 1 1";
        String[] strs = line.split(" ");
        System.out.println(strs.length);

        TreeNode tree = Utils.createTree(new Integer[]{5, 3, 6, 2, 4, null, null, 1}, 0);
        int i = kthSmallest1(tree, 3);
        System.out.println(i);
    }
}
