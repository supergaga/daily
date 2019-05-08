package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/29
 * @Description
 */
public class L665_Non_decreasingArray {
    /**
     * Given an array with n integers, your task is to check if it could become non-decreasing by modifying at most 1 element.
     *
     * We define an array is non-decreasing if array[i] <= array[i + 1] holds for every i (1 <= i < n).
     *
     * Example 1:
     * Input: [4,2,3]
     * Output: True
     * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
     * Example 2:
     * Input: [4,2,1]
     * Output: False
     * Explanation: You can't get a non-decreasing array by modify at most one element.
     * Note: The n belongs to [1, 10,000].
     *
     * @see <a href="https://leetcode.com/problems/non-decreasing-array/"/>
     */
    public static void main(String[] args) {
        int nums[] = new int[]{3,4,2,3};
        System.out.println(checkPossibility(nums));
    }

    public static boolean checkPossibility(int[] nums) {
        int result = 0 ,i =1;
        while (i<=nums.length-1){
            if (nums[i-1]>nums[i]){
                result++;
                //如果碰到要修改的  最小的修改力度是跟前一个相等 如果是第一个的话 就修改为与下一个相等
                if (i-2<0 || nums[i-2] <=nums[i]){
                    nums[i-1] = nums[i];
                }else {
                    nums[i] = nums[i-1];
                }
            }
            i++;
        }
        return result<=1;


    }
}
