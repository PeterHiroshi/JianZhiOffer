/*
 * JZ1. 二维数组中的查找
 *
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */

package com.peter8icestone.jianzhioffer.searching;

import java.util.Optional;

public class JZ1 {

    static class Solution {
        public boolean Find(int target, int [][] array) {
            int rows = array.length;
            int cols = array[0].length;
            int r = 0;
            int c = cols - 1;
            int value;
            while (r < rows && c >= 0) {
                value = array[r][c];
                if (value == target) {
                    return true;
                } else if (value > target) {
                    c --;
                } else {
                    r ++;
                }
            }
            return false;
        }
    }

    private static void testCase() {
        Solution solution = new Solution();
        Optional.of(solution.Find(9, new int[][]{{1, 2, 3}, {4, 5, 6}, {8, 9, 10}}))
                .ifPresent(System.out::println);
        Optional.of(solution.Find(7, new int[][]{{1, 2, 3}, {4, 5, 6}, {8, 9, 10}}))
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        testCase();
    }
}
