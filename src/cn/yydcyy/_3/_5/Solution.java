package cn.yydcyy._3._5;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String S) {
        int [] lastIndexsOfChar = new int[26];

        for (int i = 0; i < S.length(); i++) {
            lastIndexsOfChar[char2Index(S.charAt(i))] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int firstIndex = 0;

        while (firstIndex < S.length()){
            int lastIndex = firstIndex;
            for (int i = firstIndex; i < S.length() && i <= lastIndex; i ++){
              /*  int index = lastIndexsOfChar[char2Index(S.charAt(i))];
                if (index > lastIndex)
                    lastIndex = index;*/
              // 这个写法更容易理解
                lastIndex = Math.max(lastIndexsOfChar[char2Index(S.charAt(i))], lastIndex);
                /**
                 * 但第一个出现的 'a' 和最后一个出现的 'a' 之间可能还有其他字母，这些字母会让区间变大。举个例子，在 "abccaddbeffe" 字符串中，第一个最小的区间是 "abccaddb"。
                 * 通过以上的分析，我们可以得出一个算法：对于遇到的每一个字母，去找这个字母最后一次出现的位置，用来更新当前的最小区间。
                 */
            }
            /**
             * 结果 要尽量多划分
             * 输出: [9,7,8]
             * 解释:
             * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
             */
            partitions.add(lastIndex - firstIndex + 1);
            firstIndex = lastIndex + 1;
        }
        return partitions;
    }

    private int char2Index(char c) {
        return c - 'a';
    }

    public static void main(String[] args) {
        String str = "ababcbacadefegdehijhklij";
        Solution s = new Solution();
        s.partitionLabels(str);
    }
}