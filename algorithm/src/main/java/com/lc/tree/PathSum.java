package com.lc.tree;

import com.lc.util.TreeNode;

/**
 * 437
 * 给定一个二叉树，它的每个结点都存放着一个整数值。
 * <p>
 * 找出路径和等于给定数值的路径总数。
 * <p>
 * 路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * <p>
 * 二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PathSum {
    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = findPath(root, sum);
        res += pathSum(root.left, sum);
        res += pathSum(root.right, sum);
        return res;
    }

    /**
     * 用于找从root开始的路径，可能有负数，所以找到后只是res++，继续找
     * @param root
     * @param sum
     * @return
     */
    public static int findPath(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) {
            res++;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }
}
