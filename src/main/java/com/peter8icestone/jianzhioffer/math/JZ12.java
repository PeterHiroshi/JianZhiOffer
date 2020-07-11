/*
 *  JZ12. 数值的整数次方
 *
 *  题目描述
 *  给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 *  保证base和exponent不同时为0
 */

package com.peter8icestone.jianzhioffer.math;

public class JZ12 {

    static class Solution {
        public double Power(double base, int exponent) {
            if (base == 0) {
                return 0.0;
            }
            long exp = exponent;
            if (exp < 0) {
                exp = -exp;
                base = 1 / base;
            }
            double result = 1.0;
            while (exp != 0) {
                if ((exp & 1) == 1) {
                    result *= base;
                }
                base *= base;
                exp >>= 1;
            }
            return result;
        }
    }

    private static void testCase() {
        Solution solution = new Solution();
        System.out.println(solution.Power(2.0, 4));
    }

    public static void main(String[] args) {
        testCase();
    }
}
