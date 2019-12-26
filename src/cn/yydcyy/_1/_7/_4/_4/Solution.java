package cn.yydcyy._1._7._4._4;

/**
 * 2019年12月26日
 *
 * 提交错误显示, "01"样例应该返回 0   题目中没看到说明呢.  难道 0开头两位数都不计? 处理下加个 continue 呗
 *
 * s.charAt(0) == '0'? ...   可直接与'0' 比较, 不需要转成 int 类型和 0 比较.
 *
 *
 * ---------
 * int[] dp = new int[n + 1];
 *
 * [ string 转 int ] :  int one =Integer.valueOf(s.substring(i - 1, i))
 *
 */

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        //Integer.valueOf(s.charAt(0)) == 0 ?dp[0] == 0 : dp[1] = 1;
        //s.charAt(0) == '0'? dp[1] == 0 : dp[1] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i ++){ // 有效位 [0, n) dp[i] = if(one 符合){dp[i - 1]}  + if(two 符合){dp[ i - 2 ]}
            int one = Integer.valueOf(s.substring(i - 1, i)); // 取i-1位
            if (one > 0 && one <= 9){
                dp[i] += dp[i - 1];
            }

            if (s.charAt(i - 2) == '0')
                continue;

            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two <= 26 && two > 0){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}