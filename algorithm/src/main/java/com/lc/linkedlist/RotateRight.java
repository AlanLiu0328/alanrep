package com.lc.linkedlist;

import com.lc.util.ListNode;
import com.lc.util.Utils;

/**
 * 61
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RotateRight {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        k %= len;

        ListNode p1 = dummy, p2 = dummy;
        for (int i = 0; i < k; i++) {
            if (p2.next == null) return null;
            p2 = p2.next;
        }
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        p2.next = dummy.next;
        dummy.next = p1.next;
        p1.next = null;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = Utils.createList(new int[]{1, 2, 3, 4, 5});
        ListNode newList = rotateRight(list, 4);
        Utils.printList(newList);
    }
}
