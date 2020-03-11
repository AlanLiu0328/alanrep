package com.lc.tree.binarysearch;

import com.lc.util.TreeNode;
import com.lc.util.Utils;

/**
 * 108
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class SortedArrayToBST {
    public static TreeNode sortedArrayToBST(int[] nums) {

        TreeNode root = Utils.createBinarySearchTree(nums);
        return root;

    }

    public static void main(String[] args) {
        sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}
