package cn.yydcyy._1thinking._1_double_Pointers;

/**
 * 回文字符串
 680. Valid Palindrome II (Easy)
 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 本题的关键是处理删除一个字符。在使用双指针遍历字符串时，如果出现两个指针指向的字符不相等的情况，我们就试着删除一个字符，再判断删除完之后的字符串是否是回文字符串。

 在判断是否为回文字符串时，我们不需要判断整个字符串，因为左指针左边和右指针右边的字符之前已经判断过具有对称性质，所以只需要判断中间的子字符串即可。

 在试着删除字符时，我们既可以删除左指针指向的字符，也可以删除右指针指向的字符。
*/
class _4_Valid_PalindromeII {
    public boolean validPalindrome(String s) {
        // 题目说了"给定一个非空字符串 s", 不需要边界处理了.
        for (int i = 0, j = s.length() - 1; i <= j; i ++, j -- ) {
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1); //这一步是核心, 处理删除
            }
        }
        return true;
    }
    private boolean isPalindrome(String s, int i, int j) {
        for (; i <= j; i ++, j --) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}