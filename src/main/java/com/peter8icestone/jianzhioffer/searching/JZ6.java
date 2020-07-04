/**
 * JZ6. 旋转数组的最小数字
 *
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

package com.peter8icestone.jianzhioffer.searching;

import java.util.Optional;

public class JZ6 {

    private static class Solution {
        public int minNumberInRotateArray(int [] array) {
            if (array.length == 0) {
                return 0;
            }
            int low = 0;
            int high = array.length - 1;
            int mid;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (mid > 0 && array[mid-1] > array[mid]) {
                    return array[mid];
                }
                if (array[mid] > array[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return array[0];
        }
    }

    private static void testCase(int[] array) {
        Solution solution = new Solution();
        Optional.of(solution.minNumberInRotateArray(array))
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        testCase(new int[]{3,4,5,1,2});
        testCase(new int[]{4,3});
    }
}
