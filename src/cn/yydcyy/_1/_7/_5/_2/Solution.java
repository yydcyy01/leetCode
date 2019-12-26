package cn.yydcyy._1._7._5._2;

import java.util.Arrays;

/**
 * LeetCode 646
 *
 * ------
 * // 找出最大值
 *         //return Arrays.stream(dp).max().orElse(0);  方便. 但比自己写循环慢一点点.  53ms, 47ms
 */
class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length == 0 || pairs == null || pairs[0].length == 0 | pairs[0] == null){
            return 0;
        }

        Arrays.sort(pairs, (a, b) ->(a[0] - b[0])); // lambda 表达式编写排序规则.
        int n = pairs.length;

        int[] dp = new int[n]; // 有效范围 [0, 1), 决定 循环边界
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i ++){
            for (int j = 0; j < i; j ++){
                if (pairs[i][0] > pairs[j][1])  // a[][0] > b[][1] : a 的尾和 b 的头比较
                    dp[i] =  Math.max(dp[j] + 1, dp[i]);
            }
        }

        // 找出最大值
        //return Arrays.stream(dp).max().orElse(0);
        int len = 0;
        for (int i = 0; i < dp.length; i++) {
            len = Math.max(dp[i], len);
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findLongestChain(new int[][]{ {1,2}, {2,3}, {3,4} }));
    }
}