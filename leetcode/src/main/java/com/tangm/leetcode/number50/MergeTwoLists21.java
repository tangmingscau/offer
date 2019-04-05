package com.tangm.leetcode.number50;


/**
 * @author tony
 * @date 2019/4/5
 */
public class MergeTwoLists21 {
    public static final int[] a1 = {1, 2, 4};
    public static final int[] a2 = {1, 3, 4};

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = null;
        ListNode head1 = null;
        ListNode l2 = null;
        ListNode head2 = null;
        for (int i = 0; i < a1.length; i++) {
            if (l1 == null) {
                l1 = new ListNode(a1[i]);
                head1 = l1;
            } else {
                l1.next = new ListNode(a1[i]);
                l1 = l1.next;
            }

        }
        for (int i = 0; i < a2.length; i++) {
            if (l2 == null) {
                l2 = new ListNode(a2[i]);
                head2 = l2;
            } else {
                l2.next = new ListNode(a2[i]);
                l2 = l2.next;
            }
        }
        mergeTwoLists(head1, head2);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode node = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (head == null) {
                    node = new ListNode(l1.val);
                    head = node;
                } else {
                    node.next = new ListNode(l1.val);
                    node = node.next;
                }
                l1 = l1.next;
            } else {
                if (head == null) {
                    node = new ListNode(l2.val);
                    head = node;
                } else {
                    node.next = new ListNode(l2.val);
                    node = node.next;
                }
                l2 = l2.next;
            }
        }
        while (l1 != null) {
            if (head == null) {
                node = l1;
                head = node;
            } else {
                node.next = new ListNode(l1.val);
                node = node.next;
            }
            l1 = l1.next;
        }
        while (l2 != null) {
            if (head == null) {
                node = l2;
                head = node;
            } else {
                node.next = new ListNode(l2.val);
                node = node.next;
            }
            l2 = l2.next;
        }
//        while (head != null) {
//            System.out.println(head.val);
//            head = head.next;
//        }
        return head;
    }
}
