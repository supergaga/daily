package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2019/1/30
 * @Description
 */
public class L507_PerfectNumber {
    /**
     * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
     *
     * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
     * Example:
     * Input: 28
     * Output: True
     * Explanation: 28 = 1 + 2 + 4 + 7 + 14
     * Note: The input number n will not exceed 100,000,000. (1e8)
     * @see <a href="https://leetcode.com/problems/perfect-number/"/>
     */


    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(5));
    }

    public static boolean checkPerfectNumber(int num) {
        if (num <=2) return false;
        //第一个因子肯定是1
        int sum = 1;
        //可以通过  num/i找到较大的那个数 所以  范围在平方根一下寻找就可以
        for (int i = 2; i < (int)Math.sqrt(num); i++) {
            //如果能被整除  就找出来两个因子 相加
            if (num%i == 0)sum = sum+i +num/i;
        }
        return  sum == num;
    }
}
