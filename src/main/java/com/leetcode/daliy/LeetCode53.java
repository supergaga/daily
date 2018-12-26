package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/26
 * @Description
 */
public class LeetCode53 {


    /**
     *
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
        int num[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(num));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length ==1){
            return nums[0];
        }
        // 最大值 至少应该是数组中一个数
        int max = nums[0];
        //  应为是连续的最大值 i为每次开始的地方
        for (int i = 0; i < nums.length; i++) {
            //初始化和
            int sum =0;
            //遍历i以后的每个值的和  每次都比较 保存最大值
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                //每次遍历后得到得到的是   以i为起始位置最大的值
                max = max > sum ? max : sum;
            }
        }
        return max;

    }


}
