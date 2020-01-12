package cn.yydcyy._1._2._2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 快排 : 直接排序, 干!
 *  Time O (n log n);
 *  Space O (1);
 *
 *  堆排序
 *      Time O();
 *      Space O ();
 *  常用方法 : pq.peek(); pq.add(); pq.poll();
 */

// 快排
/*class Solution {
    public int findKthLargest(int[] nums, int k) {

        Arrays.sort(nums);
        return nums[nums.length - k ];
    }
}*/

/*
//堆排序解
class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // java 中的优先队列默认是最小堆 / 小顶堆
        for (int val : nums) {
            pq.add(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k; // 有效值
        int l = 0;  // 记录左边界起始有效值
        int h = nums.length - 1; // 记录右边界起始有效值

        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    /**
     * i, l, j, h 都是有效值下标, swap()时直接传 i, j, l, h 即可, 不要传nums[i] 啥的.
     * @param nums
     * @param l
     * @param h
     * @return
     */
    public int partition(int[] nums, int l, int h){
        int i = l + 1; //
        int j = h; // 有效值
        int part = nums[l];
        while (i < j) {
            while (i < j && nums[i] < part) i ++;  // 找到第一个 nums[i] >= part i 下标
            while (i < j && nums[j] > part) j --;// 找到第一个 nums[j] <= part j 下标
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, l, j); // part放入中间
        return j;
    }

    /**
     * 交换 nums 数组中 i, j
     * @param nums
     * @param i
     * @param j
     */
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{7,6,5,4,3,2,1};

        System.out.println(s.findKthLargest(nums, 5));
        System.out.println();
    }
}