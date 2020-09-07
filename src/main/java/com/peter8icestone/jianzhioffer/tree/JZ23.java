/*
 *  JZ23. 二叉搜索树的后序遍历序列
 *
 *  题目描述
 *  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 */

package com.peter8icestone.jianzhioffer.tree;

public class JZ23 {

    static class Solution {
        public boolean VerifySquenceOfBST(int[] sequence) {
            if (sequence.length == 0) {
                return false;
            }
            return verify(sequence, 0, sequence.length-1);
        }

        private boolean verify(int[] sequence, int low, int high) {
            if (low >= high) {
                return true;
            }
            int splitIdx = high - 1;
            int j = splitIdx;
            while (j >= low && sequence[j] > sequence[high]) {
                j --;
            }
            j --;
            while (j >= low) {
                if (sequence[j] > sequence[high]) {
                    return false;
                }
                j --;
            }
            return verify(sequence, low, splitIdx)
                    && verify(sequence, splitIdx+1, high);
        }
    }

    private static void testCase() {
        Solution solution = new Solution();
        System.out.println(solution.VerifySquenceOfBST(new int[]{5,4,3,2,1}));
    }

    public static void main(String[] args) {
        testCase();
    }
}
