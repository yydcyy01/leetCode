package cn.yydcyy._1._8._1._4._2;
/**
 * LC 168
 记得之前还有一题输出多少种解答方案.dp 两位两位判断.
 ----------
 (char)(n % 26 + 'A') 转 char
 */
class Solution {
        public String convertToTitle(int n) {
            if (n == 0) {
                return "";
            }
            n --; // n 从 1 开始而不是 0, 因此需要 -1 操作.
            return convertToTitle(n / 26) + (char) (n % 26 + 'A');
        }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(701));
    }
}