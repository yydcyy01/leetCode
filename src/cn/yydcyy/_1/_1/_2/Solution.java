package cn.yydcyy._1._1._2;

/**
LeetCode 633. 平方数之和

*/
class Solution {
    public boolean judgeSquareSum(int c) {
        if (c == 0) return true; // 0 * 0 = 0

        //int i = 1; 
        int i = 0; // 测试用例告诉我 4 应该是 0 + 4
        int j = (int)Math.sqrt(c);
        while (i <= j) { // 测试用例 4 应该返回 true, 故 应取等
            int res = i * i + j * j;
            if (res == c) {
                return true;
            } else if (res > c) {
                j --;
            } else {
                i ++;
            }
        }
        return false;
    }
}