/*
 * JZ5. 用两个栈实现队列
 *
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */

package com.peter8icestone.jianzhioffer.queue;

import java.util.EmptyStackException;
import java.util.Optional;
import java.util.Stack;

public class JZ5 {

    static class Solution {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        public void push(int node) {
            stack1.push(node);
        }

        public int pop() {
            if (stack2.empty() && stack1.empty()) {
                throw new EmptyStackException();
            }
            if (stack2.empty()) {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
    }

    private static void testCase() {
        Solution solution = new Solution();
        solution.push(1);
        solution.push(2);
        solution.push(3);
        solution.push(4);
        Optional.of(solution.pop()).ifPresent(System.out::println);
        Optional.of(solution.pop()).ifPresent(System.out::println);
        solution.push(6);
        solution.push(7);
        Optional.of(solution.pop()).ifPresent(System.out::println);
        Optional.of(solution.pop()).ifPresent(System.out::println);
        Optional.of(solution.pop()).ifPresent(System.out::println);
        Optional.of(solution.pop()).ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        testCase();
    }
}
