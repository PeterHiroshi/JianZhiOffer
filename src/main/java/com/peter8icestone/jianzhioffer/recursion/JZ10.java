/*
 *  JZ10. 矩形覆盖
 *
 *  题目描述
 *  我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

package com.peter8icestone.jianzhioffer.recursion;

public class JZ10 {

    static class Solution {
        public int RectCover(int target) {
            if (target <= 1) {
                return 1;
            }
            int dpPrePre = 1;
            int dpPre = 2;
            int tmp;
            for (int i=3; i<=target; i++) {
                tmp = dpPre;
                dpPre += dpPrePre;
                dpPrePre = tmp;
            }
            return dpPre;
        }
    }

    private static void testCase() {
        System.out.println(new Solution().RectCover(4));
    }

    public static void main(String[] args) {
        testCase();
    }
}
