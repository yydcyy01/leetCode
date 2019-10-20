package com.yydcyy.list;

import com.yydcyy.list.utils.ListNode;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author YYDCYY
 * @create 2019-10-16
 *     time O(N)
 *     space O(1)
 *     设 A 长度 a+c , B 长度 b+c,其中 c 为尾部公共长度, 可知 a+b+c = b+c+a
 *     若只是判断是否存在交点(此提示找到这个交点),则是另一题:编程之美 3.6.
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

