package cn.yydcyy._3._9;

/**
 * 122
 */
class Solution {
    // 直接买卖, 这题不难
    public int maxProfit(int[] prices) {
        if (prices.length  < 2 || prices == null ) return 0; 
        int res = 0; 
        // length >= 2
        for (int i = 1; i < prices.length; i ++){
            if (prices[i] > prices[i - 1])
                res += prices[i] - prices[i - 1];
        }
        return res;
    }
}