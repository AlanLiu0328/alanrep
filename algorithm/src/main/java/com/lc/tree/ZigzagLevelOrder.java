package com.lc.tree;

import com.lc.util.TreeNode;
import com.lc.util.Utils;

import java.util.*;

/**
 * 103
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ZigzagLevelOrder {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>(new ArrayList<>());
        }
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        queue.addLast(null);
        boolean flag = true;

        while (!queue.isEmpty()) {
            TreeNode first = queue.pollFirst();
            if (first != null) {
                if (flag) {
                    list.addLast(first.val);
                } else {
                    list.addFirst(first.val);
                }

                if (first.left != null) {
                    queue.addLast(first.left);
                }
                if (first.right != null) {
                    queue.addLast(first.right);
                }
            } else {
                flag = !flag;
                if (queue.size() > 0) {
                    queue.addLast(null);

                }
                result.add(list);
                list = new LinkedList<>();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode tree = Utils.createTree(new Integer[]{3, 9, 20, null, null, 15, 7}, 0);
        List<List<Integer>> lists = zigzagLevelOrder(tree);
        System.out.println(lists);
    }
}
