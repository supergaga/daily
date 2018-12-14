package com.leetcode.daliy;

import java.util.Arrays;

/**
 * @author TSN
 * @date 2018/12/14
 * @Description
 */
public class LeetCode88 {


    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     *
     * Note:
     *
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * Example:
     *
     * Input:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     *
     * Output: [1,2,2,3,5,6]
     * @see <a href="https://leetcode.com/problems/merge-sorted-array/" />
     */

    public static void main(String[] args) {
        int num[] = new int[]{1,2,3,0,0,0};
        int num2[] = new int[]{2,5,6};

        merge(num,3,num2,3);
        System.out.println(Arrays.toString(num));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1;
        int j = n-1;
        int k = m+n -1;
        //倒序开始
        while (i>=0 && j >=0){
            //因为是排序过的  比较最大的一个放到后面
            if (nums1[i]>nums2[j]){
                nums1[k--] = nums1[i--];
            }else {
                nums1[k--] = nums2[j--];
            }
        }
        //因为都放到第一个数组进行排序的 ，所以如果第一数组还有剩余不用管
        if (j>=0){
            while (j>=0){
                nums1[k--] = nums2[j--];
            }
        }
    }
}

