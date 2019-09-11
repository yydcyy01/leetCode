package com.yydcyy.group3;

import java.util.Comparator;
import java.util.function.BiPredicate;

/**
 * @author YYDCYY
 * @create 2019-09-12
 * 二分搜索很基础, 很重要. 是后续其他基础数据结构 (eg : 堆等)实现不可或缺的基石, LeetCode 做题中也是不可或缺的.
 *  其中的难点是 : 注意边界如何处理.  eg Java实现, 终止条件取等么? L,R 如何赋值? 处理不当会造成边界条件死循环 / 漏数导致功能残缺 等问题
 */
public class BinarySearch {
    private BinarySearch(){}

    public static int binarySearch(Comparable[] arr, int n, Comparable target){
        int L = 0, R = n - 1; // [l , r ]间

        while (L <= R){ // L == R 时, [L...R]依然有效
            int mid = (R - L) / 2 + L;
            int comp = arr[mid].compareTo(target);
            if (comp == 0)
                return mid;
            if (comp > 0)
                R = mid  - 1;
            else // comp < 0
                L = mid + 1;
        }

        return -1; // 非法情况
    }

    public static void main(String[] args) {
        int  n = (int) Math.pow(10, 7);
        Integer data[] = Util.generateOrderedArray(n);

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < n; i ++){
            if (i != binarySearch(data, n, i)){
                throw new IllegalArgumentException("find i failed");
            }
        }

        long endTime = System.currentTimeMillis();

        System.out.println("BST test complete");
        System.out.println("TIme cost : " +(endTime - startTime)+ "  ms");
    }


}
