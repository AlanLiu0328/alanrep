package com.lc.linkedlist;

import com.lc.util.ListNode;
import com.lc.util.Utils;

/**
 * 25
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * <p>
 * 示例 :
 * <p>
 * 给定这个链表：1->2->3->4->5
 * <p>
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * <p>
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseKGroup {
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tag = dummy;
        ListNode cur = dummy;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (cur.next != null) {
                    cur = cur.next;
                } else {
                    return dummy.next;
                }
            }
            ListNode next = cur.next;
            cur.next = null;
            ListNode reversed = recursion(tag.next);
            reversed.next = next;
            tag.next = cur;
            tag = reversed;
            cur = tag;
        }
    }

    public static ListNode recursion(ListNode root) {
        if (root.next == null) return root;
        ListNode p = recursion(root.next);
        root.next.next = root;
        root.next = null;
        return root;
    }

    public static void main(String[] args) {
        ListNode list = Utils.createList(new int[]{1,2,3,4, 5,6,7,8,9,10});
        ListNode newList = reverseKGroup(list, 3);
        Utils.printList(newList);
    }
}
