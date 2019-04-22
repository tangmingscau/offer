package com.tangm.leetcode.number50;

/**
 * @author tony
 * @date 2019/4/22
 */
public class MergeKLists23 {
    public static final int[] a1 = {1, 2, 4};
    public static final int[] a2 = {1, 3, 4};
    public static final int[] a3 = {1, 3, 4};
    public static final int[] a4 = {1, 6, 7};
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
        ListNode l3 = null;
        ListNode head3 = null;
        ListNode l4 = null;
        ListNode head4 = null;
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
        for (int i = 0; i < a3.length; i++) {
            if (l3 == null) {
                l3 = new ListNode(a3[i]);
                head3 = l3;
            } else {
                l3.next = new ListNode(a3[i]);
                l3 = l3.next;
            }
        }
        for (int i = 0; i < a4.length; i++) {
            if (l4 == null) {
                l4 = new ListNode(a4[i]);
                head4 = l4;
            } else {
                l4.next = new ListNode(a4[i]);
                l4 = l4.next;
            }

        }

        ListNode re= mergeKLists(new ListNode[]{head1,head2,head3,head4});
        while (re!=null){
            System.out.println(re.val);
            re=re.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        if (lists.length == 2) {
            return mergeTwoLists(lists[0], lists[1]);
        }
        int mid = lists.length / 2;
        ListNode[] l1 = new ListNode[mid];
        for (int i = 0; i < mid; i++) {
            l1[i] = lists[i];
        }
        ListNode[] l2 = new ListNode[lists.length - mid];
        for (int i = mid, j = 0; i < lists.length; i++, j++) {
            l2[j] = lists[i];
        }
        return mergeTwoLists(mergeKLists(l1),mergeKLists(l2));
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode node = new ListNode(0);
        ListNode head = node;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
            } else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            node.next = l1;
        }
        if (l2 != null) {
            node.next = l2;
        }
        return head.next;
    }

}
