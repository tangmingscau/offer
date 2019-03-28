package com.tangm.leetcode.number50;

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @author tony
 * @date 2019/3/28
 */
public class TwoSum2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode l1 = listNode1;
//        listNode1.next = new ListNode(5);
//        listNode1 = listNode1.next;
//        listNode1.next = new ListNode(5);
//        listNode1 = listNode1.next;
        ListNode listNode2 = new ListNode(9);
        ListNode l2 = listNode2;
        listNode2.next = new ListNode(9);
        listNode2 = listNode2.next;
//        listNode2.next = new ListNode(5);
//        listNode2 = listNode2.next;
        ListNode node = addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(0);
        ListNode returnNode = newNode;
        int carry = 0;
        do {
            newNode.val = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0)+ carry) % 10 ;
            carry = ((l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0)+carry) / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 != null || l2 != null || carry == 1) {
                newNode.next = new ListNode(0);
                newNode = newNode.next;
            }
        } while (l1 != null || l2 != null || carry == 1);
        return returnNode;
    }
}
