package com.lc.util;

import java.io.ObjectInputStream;
import java.util.LinkedList;

public class Utils {
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static ListNode createList(int[] arr) {
        ListNode head = new ListNode(0);
        ListNode pre = head;
        for (int i : arr) {
            ListNode node = new ListNode(i);
            pre.next = node;
            pre = node;
        }

        return head.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static TreeNode createTree(Integer[] arr, int index) {
        TreeNode root = null;
        if (index < arr.length) {
            Integer value = arr[index];
            if (value == null) {
                return null;
            }
            root = new TreeNode(value);
            root.left = createTree(arr, index * 2 + 1);
            root.right = createTree(arr, index * 2 + 2);
        }
        return root;
    }

    public static TreeNode createBinarySearchTree(int[] arr) {
        return helpTree(arr, 0, arr.length - 1);
    }

    public static TreeNode helpTree(int[] arr, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helpTree(arr, left, mid - 1);
        root.right = helpTree(arr, mid + 1, right);
        return root;
    }
}
