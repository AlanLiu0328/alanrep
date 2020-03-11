package com.lc.linkedlist;

import com.lc.util.ListNode;
import com.lc.util.Utils;

/**
 * 206
 * 反转链表
 */
public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverse(ListNode root) {
        if (root.next == null) return root;
        ListNode p = reverse(root.next);
        root.next.next = root;
        root.next = null;
        return p;
    }




    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode list = Utils.createList(arr);
        ListNode newList = reverse(list);
        Utils.printList(newList);
    }


}
