package com.lc.linkedlist;

import com.lc.util.ListNode;
import com.lc.util.Utils;

/**
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class SwapPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode p1 = null;
        ListNode p2 = null;
        ListNode next = null;

        while (pre.next != null && pre.next.next != null) {
            p1 = pre.next;
            p2 = p1.next;
            next = p2.next;
            pre.next = p2;
            p2.next = p1;
            p1.next = next;
            pre = p1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = Utils.createList(new int[]{1});

        ListNode listNode = swapPairs(list);
        Utils.printList(listNode);
    }
}
