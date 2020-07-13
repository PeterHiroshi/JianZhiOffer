/*
 *  JZ17. 树的子结构
 *
 *  题目描述
 *  输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */

package com.peter8icestone.jianzhioffer.tree;

public class JZ17 {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    static class Solution {
        public boolean HasSubtree(TreeNode root1,TreeNode root2) {
            return (root1 != null && root2 != null) &&
                    (isSubTree(root1, root2) || HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2));
        }

        private boolean isSubTree(TreeNode root1, TreeNode root2) {
            if (root2 == null) {
                return true;
            }
            if (root1 == null || (root1.val != root2.val)) {
                return false;
            }
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        }
    }

    private static void testCase() {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        System.out.println(new Solution().HasSubtree(root1, root2));
    }

    public static void main(String[] args) {
        testCase();
    }
}
