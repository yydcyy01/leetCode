package cn.yydcyy._1thinking._8._1._9._3;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] products = new int[n];
        Arrays.fill(products, 1);
        int left = 1;
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            products[i] *= left;
        }
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            products[i] *= right;
        }
        return products;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.productExceptSelf(new int[]{
                1,2,3,4}));
    }
}