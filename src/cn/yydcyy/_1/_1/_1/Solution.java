package cn.yydcyy._1._1._1;

/**
LeetCode 167. 两数之和 II - 输入有序数组
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                res[0] = i + 1; // 题目要求返回的下标值（index1 和 index2）不是从零开始的。
                res[1] = j + 1;
                return res;
            } else if (sum > target) {
                j --;
            } else {
                i ++;
            }
        }
        return res;
    }
}