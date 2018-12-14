package com.leetcode.daliy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TSN
 * @date 2018/12/14
 * @Description
 */
public class LeetCode442 {


    /**
     * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
     *
     * Find all the elements that appear twice in this array.
     *
     * Could you do it without extra space and in O(n) runtime?
     *
     * Example:
     * Input:
     * [4,3,2,7,8,2,3,1]
     *
     * Output:
     * [2,3]
     *
     * @see <a href="https://leetcode.com/problems/find-all-duplicates-in-an-array/"/>
     */

    public static void main(String[] args) {
        int num[] =  new int[]{4,3,2,7,8,2,3,1};

        findDuplicates(num).forEach(System.out::print);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> array = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            // 取绝对值 减一  得到一个newIndex
            int newIndex = Math.abs(nums[i]) - 1;

            // 如果值相同 得到的newIndex也相同
            if (nums[newIndex]<0){
                array.add(Math.abs(nums[i]));
            }
            //将 newIndex的值变为负数
            nums[newIndex] *=-1;
        }
            //返回结果集
        return array;
    }
}
