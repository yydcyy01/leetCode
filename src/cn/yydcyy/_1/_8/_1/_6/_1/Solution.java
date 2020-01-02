package cn.yydcyy._1._8._1._6._1;

/**
 * LC 67 二进制加法.
 * 没有奇淫巧技, 模拟二进制进行运算.  不过不是 1+1 = 0 这样. 而是 carry当做计数器. i == 1 ? carry ++; j == 1? carry ++; . result = carry %2; carry /= carry; 巧妙
 * --------
 * StringBuilder()挺好用的.
 * sb.reverse().toString();
 */
class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0; // 表示仅进位.  0 1 2 3 几种可能.
        StringBuilder sb = new StringBuilder();
        while (carry == 1 || i >=0 || j >= 0) {
            if (i >= 0 && a.charAt(i) == '1') {
                carry ++;
            }
            if (j >= 0 && b.charAt(j) == '1') {// char 比较 '1' 而不是 1
                carry ++;
            }
            i --;
            j --;
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.addBinary("1010","1011"));
    }
}