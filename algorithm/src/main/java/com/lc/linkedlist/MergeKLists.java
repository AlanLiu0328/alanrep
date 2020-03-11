package com.lc.linkedlist;

import com.lc.util.ListNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class MergeKLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        List<Integer> list = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(list);
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for (Integer num : list) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return head.next;
    }
}
