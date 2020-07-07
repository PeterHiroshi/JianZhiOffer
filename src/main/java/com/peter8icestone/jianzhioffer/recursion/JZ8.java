/*
 * JZ8. 跳台阶
 *
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */

package com.peter8icestone.jianzhioffer.recursion;

import java.util.Optional;

public class JZ8 {

    static class Solution {
        public int JumpFloor(int target) {
            if (target <= 1) {
                return target;
            }
            int dpPrePre = 1;
            int dpPre = 2;
            int tmp;
            for (int i=2; i<target; i++) {
                tmp = dpPre;
                dpPre += dpPrePre;
                dpPrePre = tmp;
            }
            return dpPre;
        }
    }

    private static void testCase() {
        Optional.of(new Solution().JumpFloor(5))
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        testCase();
    }
}
