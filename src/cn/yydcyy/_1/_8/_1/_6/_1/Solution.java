package cn.yydcyy._1._8._1._6._1;

class Solution {
    public String addBinary(String a, String b) {
        int la = a.length() - 1, lb = b.length() - 1;
        int carry = 0; // 表示仅进位.  0 1 2 3 几种可能.
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (carry == 1 || i <= la || j <= lb) {
            if (a.charAt(i) == 1) {
                carry ++;
            }
            if (b.charAt(j) == 1) {
                carry ++;
            }
            sb.append(carry % 2);
            carry /= 2;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

    }
}