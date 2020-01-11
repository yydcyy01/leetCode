package cn.yydcyy._1._1._5;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }

        if (n == 0) {
            return;
        }

        int l1 = m - 1;
        int l2 = n - 1;
        int len = m + n - 1; // 取得是有效值
        while (l1 >= 0 || l2 >= 0) {
            if (l1 < 0) {
                nums1[len--] = nums2[l2--];
            } else if (l2 < 0) {
                nums1[len--] = nums1[l1--];
            } else if (nums1[l1] > nums2[l2]) {
                nums1[len--] = nums1[l1--];
            } else {
                nums1[len--] = nums2[l2--];
            }
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a1 = new int[]{2,0};
        int[] a2 = new int[]{1};
        s.merge(a1, 1, a2, 1);
        System.out.println(a1[0] + ", " +  a1[1]);

    }
}