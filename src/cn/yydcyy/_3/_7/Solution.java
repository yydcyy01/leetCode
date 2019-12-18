package cn.yydcyy._3._7;

/**
 *LC 392 : 解题思路 : \
 *  在 String.t 中 挨个索引String.s [由题意, 可以不连续, 比如 "abc" "ahbgdc"查a 在 t 中索引 : index=0, 下次从 0+1 开始查 b 索引, 返回 2 下次从 2+1 开始查 c 索引, 一直查到最后 过程中只有查到最后(返回-1)直接 return false,
 *  否则就是子串, return true.    用好 String 工具类. index() , charAt 等等方法. 效率贼高.
 *  ]
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