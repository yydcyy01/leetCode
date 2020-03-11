package cn.yydcyy._1thinking._2_sorts._2;

/**
 * 215. Kth Largest Element in an Array (Medium)
 题目描述：找到倒数第 k 个的元素。
 *
 * 排序 ：时间复杂度 O(NlogN)，空间复杂度 O(1)
 *
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 */

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


class Kth_Largest_Element_In_An_Array_Medium {
    // 堆排序实现 默认最小堆, 堆顶是最小元素
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i ++) {
            pq.add(nums[i]);
            if (pq.size() > k)
                pq.poll();
        }
        return pq.peek();
    }


    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
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

    private int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;
        while (true) {
            while (a[++i] < a[l] && i < h) ;
            while (a[--j] > a[l] && j > l) ;
            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, l, j);
        return j;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void main(String[] args) {
        Kth_Largest_Element_In_An_Array_Medium s = new Kth_Largest_Element_In_An_Array_Medium();
        int[] nums = new int[]{7,6,5,4,3,2,1};

        System.out.println(s.findKthLargest(nums, 5));
        System.out.println();

    }
}


