/*
 *  JZ16. 合并两个排序的链表
 *
 *  题目描述
 *  输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */

package com.peter8icestone.jianzhioffer.linkedList;

import java.util.Optional;

public class JZ16 {

    private static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ListNode Merge(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(-1);
            ListNode ptr1 = list1;
            ListNode ptr2 = list2;
            ListNode tail = dummy;
            while (ptr1 != null && ptr2 != null) {
                if (ptr1.val <= ptr2.val) {
                    tail.next = ptr1;
                    ptr1 = ptr1.next;
                } else {
                    tail.next = ptr2;
                    ptr2 = ptr2.next;
                }
                tail = tail.next;
            }
            tail.next = (ptr1 == null) ? ptr2 : ptr1;
            return dummy.next;
        }
    }

    private static void testCase() {
        ListNode head1 = new ListNode(0);
        head1.next = new ListNode(1);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(5);
        head2.next.next.next = new ListNode(9);
        Solution solution = new Solution();
        ListNode ptr = solution.Merge(head1, head2);
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
