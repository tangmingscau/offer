package com.tangm.leetcode.number250;


import java.util.Stack;

/**
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * @author tony
 * @date 2019/4/1
 */
public class ReverseList206 {
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
        listNode1.next = new ListNode(2);
        listNode1 = listNode1.next;
        listNode1.next = new ListNode(3);
        listNode1 = listNode1.next;
        listNode1.next = new ListNode(4);
        listNode1 = listNode1.next;
        listNode1.next = new ListNode(5);
        reverseList2(l1);

    }

    public static ListNode reverseList(ListNode head) {
        //使用栈的后进先出特性
        if (head==null){
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head.next != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode nodeClone1 = head;
        while (!stack.isEmpty()) {
            ListNode node1 = stack.pop();
            head.next = node1;
            head = head.next;

        }
        head.next = null;
//        while (nodeClone1!= null) {
//            System.out.println(nodeClone1.val);
//            nodeClone1=nodeClone1.next;
//        }
        return nodeClone1;
    }
    public static ListNode reverseList2(ListNode head) {
        //官方解答，迭代
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
