package cn.yydcyy._1._7._4._1;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 279
 *
 * generateSquareList() 自己实现, 蠢一点, 但是方便好记呀.
 * temp = (int) Math.pow(i, 2); // i 的2 次方
 */
class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSquares(12));
    }

    public int numSquares(int n) {
        List<Integer> squareList = generateSquareList(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (int square : squareList) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

  /*  private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        int diff = 3;
        int square = 1;
        while (square <= n) {
            squareList.add(square);
            square += diff;
            diff += 2;
        }
        return squareList;
    }*/

    /**
     * 生成 小于 n 的所有平方数
     * @param n
     * @return
     */
    private List<Integer> generateSquareList(int n) {
        List<Integer> squareList = new ArrayList<>();
        for (int i = 1, temp = i; temp < n; i ++){
            temp = (int) Math.pow(i, 2); // i 的平方
            squareList.add(temp);
        }
        return squareList;
    }
}