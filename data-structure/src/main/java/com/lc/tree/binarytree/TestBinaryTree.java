package com.lc.tree.binarytree;

import com.lc.util.TreeNode;
import com.lc.util.Utils;
import sun.reflect.generics.tree.Tree;

public class TestBinaryTree {
    public static TreeNode insert(TreeNode root, int num) {
        if (root == null) {
            return new TreeNode(num);
        }
        if (root.val < num) {
            root.right = insert(root.right, num);
        }
        if (root.val > num) {
            root.left = insert(root.left, num);
        }
        return root;
    }

    public static TreeNode remove(TreeNode root, int num) {
        if (root == null) return null;
        if (root.val > num) {
            root.left = remove(root.left, num);
            return root;
        }
        if (root.val < num) {
            root.right = remove(root.right, num);
            return root;
        }
        if (root.val == num) {
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }
            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }
            // 左右都有子树
            TreeNode rightMin = root.right;
            TreeNode l = root.left;
            TreeNode r = root.right;
            root.left = null;
            root.right = null;

            while (rightMin.left != null) {
                rightMin = rightMin.left;
            }
            rightMin.right = removeMin(r);
            rightMin.left = l;
            return rightMin;
        }
        return null;
    }

    public static TreeNode removeMin(TreeNode root) {
        if (root.left == null) {
            TreeNode rightNode = root.right;
            root.right = null;
            return rightNode;
        }
        root.left = removeMin(root.left);
        return root;
    }

    public static TreeNode removeMax(TreeNode root) {
        if (root.right == null) {
            TreeNode leftNode = root.left;
            root.left = null;
            return leftNode;
        }
        root.right = removeMax(root.right);
        return root;
    }

    public static TreeNode find(TreeNode root, int num) {
        if (root == null) return null;
        if (root.val < num) return find(root.right, num);
        if (root.val > num) return find(root.left, num);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = Utils.createTree(new Integer[]{6, 2, 8, 1, 4, null, null, null, null, 3}, 0);
        TreeNode node = insert(root, 5);
        remove(root, 4);
        Utils.printTree(node);
    }
}
