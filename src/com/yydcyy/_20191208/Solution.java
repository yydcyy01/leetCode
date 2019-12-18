package com.yydcyy._20191208;

import java.math.BigInteger;

class Solution {
    BigInteger mul = new BigInteger("1");
    int add = 0;

    /**
    java 大树相乘.
    */
    public int subtractProductAndSum(int n) {
        String str =String.valueOf(n);
        for (int i = 0 ; i < str.length(); i ++){
            //int temp = Integer.valueOf(str.charAt(i);
            //int temp = Integer.parseInt(String.valueOf(str.charAt(i)));

            mul = mul.multiply(BigInteger.valueOf(str.charAt(i) - '0'));
        }

        for (int i = 0; i < str.length(); i ++){
            add += str.charAt(i) - '0';
        }

        return Integer.valueOf(mul.subtract(BigInteger.valueOf(add)).toString());
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.subtractProductAndSum(234));
    }
}