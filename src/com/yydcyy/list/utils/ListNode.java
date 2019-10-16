package com.yydcyy.list.utils;

/**
 * @author YYDCYY
 * @create 2019-10-17
 * 注 : vsl, next 属性设置为 public 不合理, 应该为 private, 但是为了方便做题, 先这么写
 */
public class ListNode {
    public int val;
    public ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
