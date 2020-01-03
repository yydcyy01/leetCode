package cn.yydcyy._1._8._1._9._2;

/**
 *
 * LeetCode 326
 */
class Solution {

    // 方法① , 暴力求解
    /*
    public boolean isPowerOfThree(int n) {
        boolean res = false;
        if (n <= 0) return false;
        if (n == 1) return true;  // 边界条件
        long i = 3;
        while (n >= i) {
            if (n == i) {
                res = true;
                break;
            }
            i *= 3;
        }
        return res;
    }*/

    // 方法②

        public boolean isPowerOfThree(int n) {
            // 数论知识
            return n > 0 && (1162261467 % n == 0);
            // int 范围内最大的 3 的倍数 : 1162261467 是 3^19
        }

}