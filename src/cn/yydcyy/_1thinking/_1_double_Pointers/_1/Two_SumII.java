package cn.yydcyy._1thinking._1_double_Pointers._1;

/**
 167. Two Sum II - Input array is sorted (Easy)
 Time : O(N) Space : O(1)

 注意返回结果 : int[]. 使用 new int[]{1,2};

 题目描述：在有序数组中找出两个数，使它们的和为 target。

 数组中的元素最多遍历一次，时间复杂度为 O(N)。只使用了两个额外变量，空间复杂度为 O(1)。
*/
class Two_SumII {
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