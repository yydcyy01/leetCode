package cn.yydcyy._1._8._1._4._2;

/**
 * int 32位, 1000...1 表示-1.
 * 用反码表示, 取反+1, 0111...111;
 * --------------------
 * 无符号右移, 进行处理. stringBuilder 添加
 */
class Solution {
    public String toHex(int num) {
        if (num == 0) return "0"; //边界处理, 不是"" , 而是"0"哦
        char[] map = new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.toHex(-1));
    }
}