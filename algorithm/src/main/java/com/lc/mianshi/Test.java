package com.lc.mianshi;

import com.lc.util.TreeNode;
import com.lc.util.Utils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test {
    public static List<List<Integer>> test(TreeNode root) {
        if (root == null) return new LinkedList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> curLine = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                curLine.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                if (!queue.isEmpty()) {
                    result.add(curLine);
                    curLine = new LinkedList<>();
                    queue.add(null);
                } else {
                    result.add(curLine);
                    break;
                }

            }
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode tree = Utils.createTree(new Integer[]{1, 2, 3}, 0);
        test(tree);
    }
}

