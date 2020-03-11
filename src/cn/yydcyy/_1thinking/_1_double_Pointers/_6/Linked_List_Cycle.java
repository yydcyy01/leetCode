package cn.yydcyy._1thinking._1_double_Pointers._6;

import com.yydcyy.list.utils.ListNode;
/**
 * 6. 判断链表是否存在环
 * 141. Linked List Cycle (Easy)
 *初始可以从l1 = l2 = head;
 *
 * 使用双指针，一个指针每次移动一个节点，一个指针每次移动两个节点，如果存在环，那么这两个指针一定会相遇。
 */

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
public class Linked_List_Cycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode l1 = head, l2 = head; // 若两个都从 head 开始, 则 while 循环"跳"一定要在 if(==)前.
        while (l1 != null && l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) {
                return true;
            }
        }
        return false;
    }
}