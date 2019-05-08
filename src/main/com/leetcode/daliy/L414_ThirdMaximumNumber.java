package com.leetcode.daliy;

import java.util.Arrays;

/**
 * @author TSN
 * @date 2019/1/12
 * @Description
 */
public class L414_ThirdMaximumNumber {
    /**
     * Given a non-empty array of integers, return the third maximum number in this array. If it does not exist, return the maximum number. The time complexity must be in O(n).
     *
     * Example 1:
     * Input: [3, 2, 1]
     *
     * Output: 1
     *
     * Explanation: The third maximum is 1.
     * Example 2:
     * Input: [1, 2]
     *
     * Output: 2
     *
     * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
     * Example 3:
     * Input: [2, 2, 3, 1]
     *
     * Output: 1
     *
     * Explanation: Note that the third maximum here means the third maximum distinct number.
     * Both numbers with value 2 are both considered as second maximum.
     *
     * @see <a href="https://leetcode.com/problems/third-maximum-number/"/>
     */
    public static void main(String[] args) {
    int nums[] = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax(nums));
    }
    public static int thirdMax(int[] nums) {
        int[] ints = Arrays.stream(nums).sorted().distinct().toArray();
        //小于3 返回最大的一个
        if (ints.length<3) return ints[ints.length-1];
        return ints[ints.length-3];
    }

}
