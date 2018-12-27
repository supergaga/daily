package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/14
 * @Description
 */
public class L27_RemoveElement {


    /**
     * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
     *
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     *
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     *
     * Example 1:
     *
     * Given nums = [3,2,2,3], val = 3,
     *
     * Your function should return length = 2, with the first two elements of nums being 2.
     *
     * It doesn't matter what you leave beyond the returned length.
     * Example 2:
     *
     * Given nums = [0,1,2,2,3,0,4,2], val = 2,
     *
     * Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
     *
     * Note that the order of those five elements can be arbitrary.
     *
     * It doesn't matter what values are set beyond the returned length.
     * Clarification:
     *
     * Confused why the returned value is an integer but your answer is an array?
     *
     * Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.
     *
     * Internally you can think of this:
     *
     * // nums is passed in by reference. (i.e., without making a copy)
     * int len = removeElement(nums, val);
     *
     * // any modification to nums in your function would be known by the caller.
     * // using the length returned by your function, it prints the first len elements.
     * for (int i = 0; i < len; i++) {
     *     print(nums[i]);
     * }
     *
     * @see <a href="https://leetcode.com/problems/remove-element/"/>
     */

    public static void main(String[] args) {
        int num[] = new int[]{-1,2,-1,-4};

        System.out.println(removeElement(num,2));

    }

    public static int removeElement(int[] nums, int val) {
        int begin = 0;
        int end = nums.length-1;
        int count = 0;
        //从两边开始  把所有目标值放到后边  然后记录个数
        while (begin<=end){
            //左边开始找等于目标值的角标  继续往下
            while (begin<nums.length && nums[begin] !=val){
                begin ++;
            }
            //右边找到不等于目标值的角标 继续往下 如果相等 count+1
            while (end>=0 && nums[end] ==val){
                count ++;
                end--;
            }
            //当左右角标相等， 或者左边越界   或者右边越界停止
            if (begin >= end || begin >=nums.length ||end <0){
                break;
            }
            //把目标值从前边转到后边  互换
            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
        }
        return nums.length-count;
    }
}
