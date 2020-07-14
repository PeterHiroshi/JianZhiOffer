/*
 *  JZ20. 包含min函数的栈
 *
 *  题目描述
 *  定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *  注意：保证测试中不会当栈为空的时候，对栈调用pop()或者min()或者top()方法。
 */

package com.peter8icestone.jianzhioffer;

import java.util.Stack;

public class stack {

    static class Solution {

        private Stack<Integer> mainStk = new Stack<>();
        private Stack<Integer> minStk = new Stack<>();

        public void push(int node) {
            if (minStk.empty() || node <= minStk.peek()) {
                minStk.push(node);
            }
            mainStk.push(node);
        }

        public void pop() {
            if (!minStk.empty() && minStk.peek().equals(mainStk.peek())) {
                minStk.pop();
            }
            mainStk.pop();
        }

        public int top() {
            return mainStk.peek();
        }

        public int min() {
            return minStk.peek();
        }
    }

    private static void testCase() {
        Solution solution = new Solution();
        solution.push(3);
        solution.push(1);
        solution.push(2);
        System.out.println("min=" + solution.min());
        System.out.println("top=" + solution.top());
        solution.pop();
        solution.pop();
        System.out.println("min=" + solution.min());
    }

    public static void main(String[] args) {
        testCase();
    }
}
