package cn.yydcyy._1thinking._1_double_Pointers;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 524
 *  Longest Word in Dictionary through Deleting (Medium)
 *   LongestWordInDictionaryThroughDeleting (Medium)
 */
class _7_Longest_Word_In_Dictionary_Through_Deleting_Medium {
    public String findLongestWord(String s, List<String> d) {
        String res = ""; // 记录结果

        for (String temp : d) {
            // 这个判断过程是res 与 temp 比较 , 这是个优化过程.
            int l1 = res.length(); //
            int l2 = temp.length(); // 这个别写错了撒

            if (l1 > l2 || (l1 == l2 && res.compareTo(temp) < 0) ) {
                // 处理边界 ① l1 比tmep 长 ② l1 比 temp 字典序小,优化为即使相同直接跳过
                continue;
            }
            //此方法判断是 s 与 temp 比较.
            if (isVaild(s, temp) ) {
                res = temp;
            }
        }
        return res;
    }
    //s 为 app 字典,temp 为 aoopp判断.
    public boolean isVaild(String s, String temp){
        int i = 0; // 记录 s 长度
        int j = 0; // 记录 temp 长度
        while (i < s.length() && j < temp.length() ) {
            if (s.charAt(i) == temp.charAt(j)) {
                j++;
            }
            i ++; //temp 为字典, 这里注意长的 ++; 短的(字典)j相同才++;
        }
        return j == temp.length(); // 说明此字典全匹配
    }

    public static void main(String[] args) {
        _7_Longest_Word_In_Dictionary_Through_Deleting_Medium s = new _7_Longest_Word_In_Dictionary_Through_Deleting_Medium();
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add( "apple");
        list.add("monkey");
        list.add("plea");
        String str = "abpcplea";
        System.out.println(s.findLongestWord(str, list));
    }
}