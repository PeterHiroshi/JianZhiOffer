/*
 *  JZ18. 二叉树的镜像
 *
 *  题目描述
 *  操作给定的二叉树，将其变换为源二叉树的镜像。
 */

package com.peter8icestone.jianzhioffer.tree;

import java.util.Optional;

public class JZ18 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    static class Solution {
        public void Mirror(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode tmp = root.left;
            root.left = root.right;
            root.right = tmp;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

    private static void traversalTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        traversalTree(root.left);
        traversalTree(root.right);
    }

    private static void testCase() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        traversalTree(root);
        new Solution().Mirror(root);
        System.out.println("---------------");
        traversalTree(root);
    }

    public static void main(String[] args) {
        testCase();
    }
}
