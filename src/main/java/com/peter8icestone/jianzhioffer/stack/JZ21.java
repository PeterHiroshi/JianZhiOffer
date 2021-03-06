/*
 *  JZ21. 栈的压入、弹出序列
 *
 *  题目描述
 *  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 *  例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */

package com.peter8icestone.jianzhioffer.stack;

import java.util.Stack;

public class JZ21 {

    static class Solution {
        public boolean IsPopOrder(int [] pushA,int [] popA) {
            Stack<Integer> tmpStack = new Stack<>();
            int popAIdx = 0;
            for (int pushVal : pushA) {
                tmpStack.push(pushVal);
                while (!tmpStack.empty() && tmpStack.peek().equals(popA[popAIdx])) {
                    tmpStack.pop();
                    popAIdx ++;
                }
            }
            return tmpStack.empty();
        }
    }

    private static void testCase() {
        System.out.println(new Solution().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,5,3,2,1}));
        System.out.println(new Solution().IsPopOrder(new int[]{1,2,3,4,5}, new int[]{4,3,5,1,2}));
    }

    public static void main(String[] args) {
        testCase();
    }
}
