package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2019/2/13
 * @Description
 */
public class L371_SumOfTwoIntegers {
    /**
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
     *
     * Example 1:
     *
     * Input: a = 1, b = 2
     * Output: 3
     * Example 2:
     *
     * Input: a = -2, b = 3
     * Output: 1
     * <a href = "https://leetcode.com/problems/sum-of-two-integers/" />
     */
    public static void main(String[] args) {
        System.out.println(getSum(-1,2));
    }
    public static  int getSum(int a, int b) {
        return Math.addExact(a,b);
    }
}
