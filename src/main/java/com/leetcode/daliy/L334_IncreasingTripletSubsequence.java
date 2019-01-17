package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2019/1/17
 * @Description
 */
public class L334_IncreasingTripletSubsequence {
    /**
     * Given an unsorted array return whether an increasing subsequence of length 3 exists or not in the array.
     *
     * Formally the function should:
     *
     * Return true if there exists i, j, k
     * such that arr[i] < arr[j] < arr[k] given 0 ≤ i < j < k ≤ n-1 else return false.
     * Note: Your algorithm should run in O(n) time complexity and O(1) space complexity.
     *
     * Example 1:
     *
     * Input: [1,2,3,4,5]
     * Output: true
     * Example 2:
     *
     * Input: [5,4,3,2,1]
     * Output: false
     * @see <a href="https://leetcode.com/problems/increasing-triplet-subsequence/"/>
     */
    public static void main(String[] args) {
        int a[] = new int[]{5,4,3,2,1};
        System.out.println(increasingTriplet(a));
    }
    public static boolean increasingTriplet(int[] nums) {
            int max = Integer.MAX_VALUE;
            int min = Integer.MAX_VALUE;
        for (int num : nums) {
            //先找一个最小的数
            if (num<min){
                min= num;
                //当大于这个数 进入下一个判断
            }else if (num <max){
                max = num;
                //不满足 找到第三个 递增的  返回true
            }else {
                return true;
            }
        }
        return false;

    }
}
