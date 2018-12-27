package com.leetcode.daliy;

public class LeetCode52 {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
     *
     * Example:
     *
     * Input: [-2,1,-3,4,-1,2,1,-5,4],
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     * Follow up:
     *
     * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
     *
     * @see <a href="https://leetcode.com/problems/maximum-subarray/"/>
     */

    public static void main(String[] args) {
        int nums[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        //初始化max
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            //每次都初始化sum  用来记录从i往后的 和
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                //记录从i 到 j 的和
                sum += nums[j];
                // 记录最大值
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}
