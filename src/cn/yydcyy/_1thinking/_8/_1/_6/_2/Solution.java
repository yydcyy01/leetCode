package cn.yydcyy._1thinking._8._1._6._2;

/**
 * LC 415
 * 十进制加法.
 *别忘处理 i-- , j--, OOM 多尴尬.
 * ---------
 * char 转 int.
 * num2.charAt(j) - '0'
 */
class Solution {
    public String addStrings(String num1, String num2) {
        if (num1.length() == 0 || num1 == null ) return num2;
        if (num2.length() == 0 || num2 == null ) return num1;

        int i = num1.length() - 1, j = num2.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (carry == 1 || i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += num1.charAt(i) - '0';
            }
            if (j >= 0) {
                carry += num2.charAt(j) - '0';
            }
            i --;
            j --;
            sb.append(carry % 10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addStrings("123", "123"));
    }
}