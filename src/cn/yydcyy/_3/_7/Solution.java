package cn.yydcyy._3._7;

/**
 *
 *
 *
 *
 * 方法 :
 * String.toCharArray() : 转为char[] 数组
 * public int indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 *
 * public int indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 *
 * int indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 *
 * int indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
 *
 * String 类好好好了解下
 */
class Solution {
    public boolean isSubsequence(String s, String t) {
        int index = 0-1;
        for (char c : s.toCharArray()){
            index =   t.indexOf(c, index + 1);
            if (index == -1){
                return false;
            }
        }
        return true;
    }
}