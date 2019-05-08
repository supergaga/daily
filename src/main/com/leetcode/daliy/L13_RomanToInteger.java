package com.leetcode.daliy;

import java.util.Arrays;

/**
 * @author TSN
 * @date 2018/12/14
 * @Description
 */
public class L13_RomanToInteger {
    /**
     * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
     *
     * Return the sum of the three integers. You may assume that each input would have exactly one solution.
     *
     * Example:
     *
     * Given array nums = [-1, 2, 1, -4], and target = 1.
     *
     * The sum that is closest to the target is 2
     *   (-1 + 2 + 1 = 2)
     *
     * @see <a href="https://leetcode.com/problems/3sum-closest/"/>
     */

    public static void main(String[] args) {

        int num[] = new int[]{-1,2,1,-4};

        System.out.println(threeSumClosest(num,2));
    }

    public static  int threeSumClosest(int[] nums, int target) {

        if (nums.length==3)
            return nums[0] +nums[1] +nums[2];
        //将数组排序
        Arrays.sort(nums);
        int maxTemp = Integer.MAX_VALUE;
        int sum ;
        int result = 0;
        //最后要保证3个数 i<nums.length-2
        for (int i = 0; i < nums.length - 2; i++) {
            //i从0开始  left在i右边与right往中间移动
            int left = i+1;
            int right = nums.length-1;
            // 第一个指针不动  移动后边两个指针  因为是有序的 所以 可以判断出需要移动的是第一个还是第二个指针
            while (left<right){
                //三数之和
                sum = nums[i] + nums[left] + nums[right];
                // 绝对值 距离
                int a = Math.abs(sum - target);
                //取最小的
                if (a<maxTemp){
                    maxTemp = a;
                    result = sum;
                }
                //如果相等直接返回
                if (sum == target){
                    return  target;
                }
                //根据sum的大小 考虑移动左边还是右边的指针
                if (sum<target){
                    left++;
                }else {
                    right--;
                }

            }

        }
        return result;


    }
}
