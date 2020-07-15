/*
 *  JZ22. 从上往下打印二叉树
 *
 *  题目描述
 *  从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

package com.peter8icestone.jianzhioffer.queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

public class JZ22 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    static class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Optional.ofNullable(queue.poll())
                        .ifPresent(node -> {
                            result.add(node.val);
                            queue.add(node.left);
                            queue.add(node.right);
                        });
            }
            return result;
        }
    }

    private static void testCase() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        new Solution().PrintFromTopToBottom(root)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        testCase();
    }
}
