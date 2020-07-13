/*
 *  JZ14. 链表中倒数第k个结点
 *
 *  题目描述
 *  输入一个链表，输出该链表中倒数第k个结点。
 */

package com.peter8icestone.jianzhioffer.linkedList;

import java.util.Optional;

public class JZ14 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ListNode FindKthToTail(ListNode head, int k) {
            if (k < 1) {
                return null;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode slowPtr = dummy;
            ListNode fastPtr = dummy;
            int num = 1;
            while (fastPtr.next != null) {
                if (num >= k) {
                    slowPtr = slowPtr.next;
                }
                fastPtr = fastPtr.next;
                num ++;
            }
            return slowPtr == dummy ? null : slowPtr;
        }
    }

    private static void testCase() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        Optional.ofNullable(solution.FindKthToTail(head, 2))
                .map(listNode -> listNode.val)
                .ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        testCase();
    }
}
