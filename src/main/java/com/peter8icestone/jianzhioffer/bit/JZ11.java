/*
 *  JZ11. 二进制中1的个数
 *
 *  题目描述
 *  输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 */

package com.peter8icestone.jianzhioffer.bit;

public class JZ11 {

    static class Solution {
        public int NumberOf1(int n) {
            int number = 0;
            while (n != 0) {
                n &= n-1;
                number ++;
            }
            return number;
        }
    }

    private static void testCase() {
        System.out.println(new Solution().NumberOf1(0b0111010001));
    }

    public static void main(String[] args) {
        testCase();
    }
}
