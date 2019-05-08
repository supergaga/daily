package com.leetcode.daliy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TSN
 * @date 2018/12/13
 * @Description
 */
public class L1_TwoSum {
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @see <a href="https://leetcode.com/problems/two-sum/"/>
 */

    public static void main(String[] args) {
        int num[] = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(num,9)));

    }


        public static int[] twoSum(int[] nums, int target) {
            Map result =  new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int temp = target - nums[i];
                if (result.containsKey(temp)){
                    return new int[]{i,(int)result.get(temp)};
                }
                result.put(nums[i],i);
            }

            return null;
            //
            //
            //
            //5555
            //6666
            //7777
            //8888
            //9999
        }

}
