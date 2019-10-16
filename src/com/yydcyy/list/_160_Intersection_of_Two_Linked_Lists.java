package com.yydcyy.list;

import com.yydcyy.list.utils.ListNode;

/**
 * @author YYDCYY
 * @create 2019-10-16
 */
public class _160_Intersection_of_Two_Linked_Lists {
    //public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode h1= headA;
            ListNode h2 = headB;
            while (h1 != h2){
                h1 = (h1 != null) ? h1.next:headB;
                h2 = (h2 != null) ? h2.next:headA;
            }
            return h1;
        }
    //}
}
