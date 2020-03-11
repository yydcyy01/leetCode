package cn.yydcyy._1thinking._1_double_Pointers._3;

import java.util.Arrays;
import java.util.HashSet;

/**
 345. Reverse Vowels of a String (Easy)

Time O(N)元音字母查找hash 效率 O(1) Space O(n)

 我的写法更有普适性, 比if else逻辑判断多了跳转过程. 还好啦.
------------
①
处理 string需要修改时, 可用char[] res = new char[s.length()];
结束返回 string, new String(res); // res.toString();返回的是 HashCode;
② 
需要查找匹配一个数组时 [比如此题中预先定义的元音数组集合], 用"时间换空间" HashSet 的 contains()方法. 
*/
class Reverse_Vowels_of_a_String {
    HashSet<Character> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u','A','E','I','O','U'));
    public String reverseVowels(String s) {
        if (s.length() == 0 || s == "") return s;

        char[] res = new char[s.length()];
        int i = 0;
        int j = s.length() - 1; // 有效值
        while (i <= j) {
            // 不包含, 直接赋值,  包含, 交换 ij
            while (i < s.length() && !vowels.contains(s.charAt(i))) {
                res[i] = s.charAt(i);
                i ++;
            } // 遇到vowel 停止.

            while (j >= 0 && !vowels.contains(s.charAt(j))) {
                res[j] = s.charAt(j);
                j --;
            } // 遇到vowel 停止.
            
            if (i <= j && vowels.contains(s.charAt(i)) && vowels.contains(s.charAt(j))) {
                res[i] = s.charAt(j);
                res[j] = s.charAt(i);
                i ++;
                j --;
            }
        }
        return new String(res);
    }
}