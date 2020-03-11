package cn.yydcyy._1thinking._1_doublePointers._6;

import com.yydcyy.list.utils.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        boolean res =false;
        if (head == null ) return true;
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }
}