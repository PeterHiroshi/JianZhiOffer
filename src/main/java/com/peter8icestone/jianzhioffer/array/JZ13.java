/*
 *  JZ13. 调整数组顺序使奇数位于偶数前面
 *
 *  题目描述
 *  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 *  并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */

package com.peter8icestone.jianzhioffer.array;

import java.util.Arrays;
import java.util.Optional;

public class JZ13 {

    static class Solution {
        public void reOrderArray(int [] array) {
            int len = array.length;
            int j;
            int finishedEvenNum = 0;
            int tmp;
            for (int i=0; i<len; i++) {
                if (array[i] % 2 == 1) {
                    j = i;
                    while (j > finishedEvenNum) {
                        tmp = array[j-1];
                        array[j-1] = array[j];
                        array[j] = tmp;
                        j --;
                    }
                    finishedEvenNum ++;
                }
            }
        }
    }

    private static void testCase() {
        int[] array = new int[]{1,2,3,4,5,6};
        Solution solution = new Solution();
        solution.reOrderArray(array);
        Arrays.stream(array).forEach(System.out::println);
    }

    public static void main(String[] args) {
        testCase();
    }
}
