package com.lc.linkedlist;

import com.lc.util.ListNode;
import com.lc.util.Utils;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 */
public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p1 = dummy, p2 = dummy;
        for (int i = 0; i < n; i++) {
            if (p2.next != null) {
                p2 = p2.next;
            } else {
                return null;
            }
        }

        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        ListNode next = p1.next.next;
        p1.next = next;
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode list = Utils.createList(new int[]{1});
        ListNode listNode = removeNthFromEnd(list, 3);
        Utils.printList(listNode);
    }
}
