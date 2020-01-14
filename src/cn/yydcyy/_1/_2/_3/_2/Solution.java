package cn.yydcyy._1._2._3._2;

/**
 * LeetCode 69  x 的平方根
 */
class Solution {
    public int mySqrt(int x) {
        if (x <= 1) return x;
        int l = 1; //
        int h = x;
        while (l <= h) { // ① 这是一个正常二分, 需要取等
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (mid > sqrt) { // 这是一个坑, mid > sqrt 比 sqrt < mid 易于理解
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h; // ③ 返回h , 而不是 l
    }
}