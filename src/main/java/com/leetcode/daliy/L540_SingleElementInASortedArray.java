package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/28
 * @Description
 */
public class L540_SingleElementInASortedArray {

    /**
     * Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once.
     *
     * Example 1:
     * Input: [1,1,2,3,3,4,4,8,8]
     * Output: 2
     * Example 2:
     * Input: [3,3,7,7,10,11,11]
     * Output: 10
     * Note: Your solution should run in O(log n) time and O(1) space.
     *
     * @see <a href="https://leetcode.com/problems/single-element-in-a-sorted-array/"/>
     */

    public static void main(String[] args) {

        int nums[] = new int[]{1,1,2,3,3,4,4,8,8};

        System.out.println(singleNonDuplicate(nums));

    }


    public static int singleNonDuplicate(int[] nums) {
        int start = 0,end = nums.length-1;

        while (start<end){
            int mid = (start + end) /2;
            //确保在偶数位 后边会用到
            if (mid %2 ==1) {
                mid--;
            }
            //如果偶数位 跟下一位不相等 证明  在前边部分出现了单个的
            if (nums[mid] != nums[mid+1]){
                end = mid;
            } else {
                //相等的话  证明前边的都是 满足一对一对的
                start = mid +2;
            }

        }
        //当不满足start<end  选择开始位置的
        return nums[start];

    }
}
