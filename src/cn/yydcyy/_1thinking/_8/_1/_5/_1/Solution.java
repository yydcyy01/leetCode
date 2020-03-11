package cn.yydcyy._1thinking._8._1._5._1;

/**
 * LC 172
因为0 是由 2*5 得来. 统计 5, 25, 125 等倍数即可.

 编程之美有一题类似, 统计 N!中二进制表示最低为 1 的位置. 统计多少个 2 即可.统计 n/2, n/2^2 , n/2^3, n/2^4 .... (2^n < N)
 --------------
*/
class Solution {
    public int trailingZeroes(int n) {
        if (n == 0)
            return 0;
       
       return n / 5 + trailingZeroes(n / 5); // 统计 n/5, n/5^2 , n/5^3, n/5^4 .... (5^n < N), 因为0 是由 2*5 得来. 统计 5, 25, 125 等倍数即可.
    }
}