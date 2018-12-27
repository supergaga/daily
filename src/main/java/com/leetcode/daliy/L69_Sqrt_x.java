package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/27
 * @Description
 */
public class L69_Sqrt_x {
    /**
     * Implement int sqrt(int x).
     *
     * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
     *
     * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
     *
     * Example 1:
     *
     * Input: 4
     * Output: 2
     * Example 2:
     *
     * Input: 8
     * Output: 2
     * Explanation: The square root of 8 is 2.82842..., and since
     *              the decimal part is truncated, 2 is returned.
     *
     * @see <a href="https://leetcode.com/problems/sqrtx/"/>
     */

    public static void main(String[] args) {
        System.out.println(mySqrt(1));
    }

    public static int mySqrt(int x) {
        // 平方根 一定小于 1/2    所以用右边做右边界
        double right = (x/2)+1;
        // 左边界为0
        double left = 0;
        //二分法
        while (left<=right){

            double mid = (right + left) / 2;

            if (mid * mid == x){
                return  (int)mid;
            }else if (mid * mid < x){
                left = mid+1;
            }else {
                right = mid-1;
            }

        }
        return (int)right;

    }

}
