package com.tangm.suanfa.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author tony
 * @date 2019/4/15
 */
public class BinTree {
    static class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
        boolean flag = true;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode pNode = node;
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        preTravel2(pNode);
    }

    /**
     * 先序遍历
     *
     * @param tree
     */
    public static void preTravel(TreeNode tree) {
        if (tree == null) {
            return;
        }
        System.out.println(tree.val);
        preTravel(tree.left);
        preTravel(tree.right);
    }

    /**
     * 先序遍历，非递归实现
     *
     * @param tree
     */
    public static void preTravel2(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = tree;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                System.out.println(node.val);
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
    }

    /**
     * 中序遍历
     *
     * @param tree
     */
    public static void midTravel(TreeNode tree) {
        if (tree == null) {
            return;
        }
        midTravel(tree.left);
        System.out.println(tree.val);
        midTravel(tree.right);
    }

    public static void midTravel2(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = tree;
        while (node != null || !stack.isEmpty()) {
            if (node != null) {
                stack.push(node);
                node = node.left;

            } else {
                node = stack.pop();
                System.out.println(node.val);
                node = node.right;
            }
        }
    }

    /**
     * 后序遍历
     *
     * @param tree
     */
    public static void postTravel(TreeNode tree) {
        if (tree == null) {
            return;
        }
        postTravel(tree.left);
        postTravel(tree.right);
        System.out.println(tree.val);
    }

    /**
     * 后序遍历非递归实现
     *
     * @param tree
     */
    public static void postTravel2(TreeNode tree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = tree;
        stack.push(node);
        while (!stack.isEmpty()) {
            while (node.left != null) {
                if (node.left.flag) {
                    stack.push(node.left);
                    node = node.left;
                } else {
                    break;
                }
            }
            node = stack.pop();
            if (node.flag) {
                node.flag = false;
                stack.push(node);
            } else {
                System.out.println(node.val);
            }
            while (node.right != null) {
                if (node.right.flag) {
                    stack.push(node.right);
                    node = node.right;
                } else {
                    break;
                }
            }
        }
    }

    /**
     * bfs 层次遍历 广度优先
     *
     * @param treeNode
     */
    public static void levelTravel(TreeNode treeNode) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(treeNode);
        while (!queue.isEmpty()) {
            TreeNode tree = queue.poll();
            System.out.println(tree.val);
            if (tree.left != null) {
                queue.offer(tree.left);
            }
            if (tree.right != null) {
                queue.offer(tree.right);
            }
        }
    }

    public static void dfs(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
