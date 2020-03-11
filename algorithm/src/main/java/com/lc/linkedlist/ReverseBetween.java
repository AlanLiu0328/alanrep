package com.lc.linkedlist;

import com.lc.util.ListNode;
import com.lc.util.Utils;

/**
 * 92
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode pre = dummy;
        for (int i = 0; i < m-1 ; i++) {
            pre = pre.next;
        }
        cur = pre.next;
        ListNode tag = cur;
        for (int i = 0; i <= n - m; i++) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        tag.next.next = pre;
        tag.next = cur;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list = Utils.createList(new int[]{1,2,3,4, 5});
        ListNode newList = reverseBetween(list, 2, 4);
        Utils.printList(newList);
    }
}
