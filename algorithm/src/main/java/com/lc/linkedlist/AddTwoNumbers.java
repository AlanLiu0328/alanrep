package com.lc.linkedlist;

import com.lc.util.ListNode;

import java.util.Stack;

/**
 * 2
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode cur = l;
        int flag = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = (n1 + n2 + flag) % 10;
            flag = (n1 + n2 + flag) / 10;
            cur.next = new ListNode(sum);
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (flag == 1) {
            cur.next = new ListNode(1);
        }
        return l.next;
    }

}
