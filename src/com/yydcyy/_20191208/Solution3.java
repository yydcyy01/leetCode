package com.yydcyy._20191208;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

/**
 * @author YYDCYY
 * @create 2019-12-08
 */
public class Solution3 {
    int res = 0;
        public int smallestDivisor(int[] nums, int threshold) {
            res = threshold;
            for (int thr = threshold; thr >= 1 ; thr --) {
                int temp = 0;
                for ( int index = 0; index < nums.length; index ++) {
                    temp += (int) Math.ceil(nums[index] / ((double)thr));
                }
                if (temp <= threshold){
                    res = res > thr ? thr : res;
                }
            }
            return res;
        }

    public static void main(String[] args) {
            Solution3 s = new Solution3();
        int[] nums = new int[]{2,3,5,7,11};
        int threshold = 11;
        System.out.println(s.smallestDivisor(nums, threshold));
    }
}
