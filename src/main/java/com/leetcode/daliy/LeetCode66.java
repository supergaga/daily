package com.leetcode.daliy;

import java.util.Arrays;

/**
 * @author TSN
 * @date 2018/12/14
 * @Description
 */
public class LeetCode66 {
    /**
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     *
     * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
     *
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     *
     * Example 1:
     *
     * Input: [1,2,3]
     * Output: [1,2,4]
     * Explanation: The array represents the integer 123.
     * Example 2:
     *
     * Input: [4,3,2,1]
     * Output: [4,3,2,2]
     * Explanation: The array represents the integer 4321.
     *
     * @see <a href="https://leetcode.com/problems/plus-one/"/>
     */

    public static void main(String[] args) {
        int num[] = new int[]{1,2,1,9};

        System.out.println(Arrays.toString(plusOne(num)));


    }
    public static int[] plusOne(int[] digits) {
        // 是否所有位数都是9
        boolean flag = true;
        for (int i = 0; i < digits.length; i++) {

            if (digits[i] != 9){
                flag = false;
                break;
            }

        }
        //如果所有位数都是9 数组扩大一位 首位变成1
        if (flag){
            int[] result = new int[digits.length+1];
            result[0] = 1;
            return result;
        }else {
            //看最后一位  如果不等于9 就+1然后停止循环 如果等于9就变成0  继续循环
            for (int i = digits.length-1; i >=0 ; i--) {
                if (digits[i] !=9){
                    digits[i] +=1;
                    break;
                }
                digits[i] =0;

            }
        }

        return digits;


    }
}
