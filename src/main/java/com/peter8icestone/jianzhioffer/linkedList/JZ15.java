/*
 *  JZ15. 反转链表
 *
 *  题目描述
 *  输入一个链表，反转链表后，输出新链表的表头。
 */

package com.peter8icestone.jianzhioffer.linkedList;

import java.util.Optional;

public class JZ15 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ListNode ReverseList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prePtr = head;
            ListNode postPtr = head.next;
            prePtr.next = null;
            ListNode tmp;
            while (postPtr != null) {
                tmp = postPtr.next;
                postPtr.next = prePtr;
                prePtr = postPtr;
                postPtr = tmp;
            }
            return prePtr;
        }
    }

    private static void testCase() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        Solution solution = new Solution();
        head = solution.ReverseList(head);
        ListNode ptr = head;
        while (ptr != null) {
            Optional.of(ptr)
                    .map(node -> node.val)
                    .ifPresent(System.out::println);
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        testCase();
    }
}
