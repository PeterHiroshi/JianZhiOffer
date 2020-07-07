/*
 * JZ3. 从尾到头打印链表
 */

package com.peter8icestone.jianzhioffer.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JZ3 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> result = new ArrayList<>();
            if (listNode == null) {
                return result;
            }
            ListNode preNode = listNode;
            ListNode curNode = listNode.next;
            preNode.next = null;
            ListNode tmp;
            while (curNode != null) {
                tmp = curNode.next;
                curNode.next = preNode;
                preNode = curNode;
                curNode = tmp;
            }
            ListNode ptr = preNode;
            while (ptr != null) {
                result.add(ptr.val);
                ptr = ptr.next;
            }
            return result;
        }
    }

    private static void testCase() {
        Solution solution = new Solution();
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        List<Integer> result = solution.printListFromTailToHead(root);
        Optional.ofNullable(result).ifPresent(System.out::println);
    }

    public static void main(String[] args) {
        testCase();
    }
}
