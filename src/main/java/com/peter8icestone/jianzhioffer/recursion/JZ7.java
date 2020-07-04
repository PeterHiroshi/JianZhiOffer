/**
 * JZ7. 斐波那契数列
 *
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 */

package com.peter8icestone.jianzhioffer.recursion;

import java.util.Optional;

public class JZ7 {

    private static class Solution {
        public int Fibonacci(int n) {
            if (n <= 1) {
                return n;
            }
            int dpPrePre = 0;
            int dpPre = 1;
            int tmp;
            for (int i=2; i<=n; i++) {
                tmp = dpPre;
                dpPre = dpPre + dpPrePre;
                dpPrePre = tmp;
            }
            return dpPre;
        }
    }

    private static class Solution2 {
        public int Fibonacci(int n) {
            int[] dp = new int[40];
            dp[0] = 0;
            dp[1] = 1;
            for (int i=2; i<=n; i++) {
                dp[i] = dp[i-2] + dp[i-1];
            }
            return dp[n];
        }
    }

    private static void testCase1() {
        Solution solution = new Solution();
        Optional.of(solution.Fibonacci(5)).ifPresent(System.out::println);
    }

    private static void testCase2() {
        Solution2 solution = new Solution2();
        Optional.of(solution.Fibonacci(5)).ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        testCase1();
        testCase2();
    }
}
