package cn.yydcyy._1._8._1._3._1;

/**
 * LeetCode 204
 *
 *
 * ------------
 * i = 499979时 ArrayIndexOutOfBoundsException 溢出 解决方法 : 先转成 long, 再转回来
 * for (long j = (long)(i) * i; j < n; j += i) {
 *                 notPrimes[j] = true;
 */
class Solution {
    public int countPrimes(int n) {
        boolean[] notPrimes = new boolean[n + 1];// 默认全是质数 prime number
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrimes[i]) {
                continue;
            }
            count++;
            // 从 i * i 开始，因为如果 k < i，那么 k * i 在之前就已经被去除过了
            /*for (long j = (long)(i) * i; j < n; j += i) {
                notPrimes[j] = true;
            }*/
            //质数的倍数为非质数
            for (int j = 2; j * i < n; j ++){
                notPrimes[j * i] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.countPrimes(10));

    }
}

/**
 java.lang.ArrayIndexOutOfBoundsException: -2146737495
 at line 12, Solution.countPrimes
 at line 57, __DriverSolution__.__helper__
 at line 85, __Driver__.main
 最后执行的输入：
 499979
 */