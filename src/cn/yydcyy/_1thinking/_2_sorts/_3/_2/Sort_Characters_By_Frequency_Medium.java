package cn.yydcyy._1thinking._2_sorts._3._2;

import java.util.*;

/**
 *451. Sort_Characters_By_Frequency_Medium
 *
 * Leetcode / 力扣
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 */
class Sort_Characters_By_Frequency_Medium {
    public String frequencySort(String s) {
        /**
         *
         * 1. String 转为 char[] 统计词频.
         * 2. 桶排序
         * 3. 从后往前便利, 全部加入 StringBuilder中.
         * 4. return 字符串
         */

        Map<Character, Integer> frequencyForNum = new HashMap<>();
        for (char num : s.toCharArray()) {
            frequencyForNum.put(num, frequencyForNum.getOrDefault(num, 0) + 1);
        }

        List<Character>[] buckets = new ArrayList[s.length() + 1]; // 生成 s.length()+1 长度, 因为是字母, 长度可以优化为 27 [0, 26] 不对, 桶是 fre频次, 还是不能优化!
        for (Character key : frequencyForNum.keySet()) {
            int frequency = frequencyForNum.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        //处理结果
        StringBuilder sb = new StringBuilder();
        for (int i = buckets.length - 1; i >= 0; i --) {
            if (buckets[i] == null) {
                continue;
            }
            // 这个双重迭代是保证 tree 变成 eert 而非 ert.
            for (char c : buckets[i]) // 保证 eert 而非 eer [遍历所有频次为 1 buckets]
                for (int j = i; j > 0; j --)
                    sb.append(c);
        }

        return sb.toString();
    }
}