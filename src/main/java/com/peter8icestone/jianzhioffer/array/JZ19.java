/*
 *  JZ19. 顺时针打印矩阵
 *
 *  题目描述
 *  输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 *  例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 *  则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

package com.peter8icestone.jianzhioffer.array;

import java.util.ArrayList;

public class JZ19 {

    static class Solution {
        public ArrayList<Integer> printMatrix(int [][] matrix) {
            ArrayList<Integer> result = new ArrayList<>();
            if (matrix.length == 0) {
                return result;
            }
            int left = 0;
            int right = matrix[0].length - 1;
            int up = 0;
            int down = matrix.length - 1;
            while (true) {
                // left -> right
                for (int i=left; i<=right; i++) {
                    result.add(matrix[up][i]);
                }
                if (++up > down) {
                    break;
                }
                // up -> down
                for (int i=up; i<=down; i++) {
                    result.add(matrix[i][right]);
                }
                if (--right < left) {
                    break;
                }
                // right -> left
                for (int i=right; i>=left; i--) {
                    result.add(matrix[down][i]);
                }
                if (--down < up) {
                    break;
                }
                // down -> up
                for (int i=down; i>=up; i--) {
                    result.add(matrix[i][left]);
                }
                if (++left > right) {
                    break;
                }
            }
            return result;
        }
    }

    private static void testCase() {
        int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        new Solution().printMatrix(matrix).forEach(System.out::println);
    }

    public static void main(String[] args) {
        testCase();
    }
}
