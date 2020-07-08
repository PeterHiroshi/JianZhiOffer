/*
 *  JZ9. 变态跳台阶
 *
 *  题目描述
 *  一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

package com.peter8icestone.jianzhioffer.greedy;

public class JZ9 {

    static class Solution1 {
        public int JumpFloorII(int target) {
            int result = 1;
            if (target == 1) {
                return result;
            }
            for (int i=2; i<=target; i++) {
                result *= 2;
            }
            return result;
        }
    }

    static class Solution2 {
        public int JumpFloorII(int target) {
            return (int) Math.pow(2, target - 1);
        }
    }

    private static void testCase() {
        System.out.println(new Solution1().JumpFloorII(4));
        System.out.println(new Solution2().JumpFloorII(4));
    }

    public static void main(String[] args) {
        testCase();
    }
}
