/*
 * JZ4. 重建二叉树
 */

package com.peter8icestone.jianzhioffer.tree;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class JZ4 {

    // Definition for binary tree
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
         val = x;
        }
    }

    static class Solution {
        public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
            return reConstructBinaryTreeWithList(Arrays.stream(pre).boxed().collect(Collectors.toList()),
                    Arrays.stream(in).boxed().collect(Collectors.toList()));
        }

        private TreeNode reConstructBinaryTreeWithList(List<Integer> pre, List<Integer> in) {
            if (pre.isEmpty() || in.isEmpty()) {
                return null;
            }
            if (pre.size() != in.size()) {
                return null;
            }
            if (pre.size() == 1) {
                return new TreeNode(pre.get(0));
            }
            int rootVal = pre.get(0);
            TreeNode rootNode = new TreeNode(rootVal);
            int rootIndexIn = in.indexOf(rootVal);
            List<Integer> leftIn = in.subList(0, rootIndexIn);
            List<Integer> rightIn = in.subList(rootIndexIn+1, in.size());
            List<Integer> leftPre = pre.subList(1, rootIndexIn+1);
            List<Integer> rightPre = pre.subList(rootIndexIn+1, pre.size());
            rootNode.left = reConstructBinaryTreeWithList(leftPre, leftIn);
            rootNode.right = reConstructBinaryTreeWithList(rightPre, rightIn);
            return rootNode;
        }
    }

    private static void traversalPreOrder(TreeNode rootNode) {
        Optional.ofNullable(rootNode).ifPresent(node -> System.out.print(node.val + " "));
        Optional.ofNullable(rootNode.left).ifPresent(JZ4::traversalPreOrder);
        Optional.ofNullable(rootNode.right).ifPresent(JZ4::traversalPreOrder);
    }

    private static void traversalInOrder(TreeNode rootNode) {
        Optional.ofNullable(rootNode)
                .map(node -> node.left)
                .ifPresent(JZ4::traversalInOrder);
        Optional.ofNullable(rootNode).ifPresent(node -> System.out.print(node.val + " "));
        Optional.ofNullable(rootNode)
                .map(node -> node.right)
                .ifPresent(JZ4::traversalInOrder);
    }

    private static void testCase() {
         Solution solution = new Solution();
         TreeNode rootNode = solution.reConstructBinaryTree(new int[]{1,2,4,7,3,5,6,8},
                 new int[]{4,7,2,1,5,3,8,6});
         traversalPreOrder(rootNode);
         System.out.println();
         traversalInOrder(rootNode);
    }

    public static void main(String[] args) {
        testCase();
    }
}
