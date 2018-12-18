package com.leetcode.daliy;

import java.util.Arrays;

/**
 * @author TSN
 * @date 2018/12/18
 * @Description
 */
public class LeetCode75 {
    /**
     * Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.
     *
     * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
     *
     * Note: You are not suppose to use the library's sort function for this problem.
     *
     * Example:
     *
     * Input: [2,0,2,1,1,0]
     * Output: [0,0,1,1,2,2]
     * Follow up:
     *
     * A rather straight forward solution is a two-pass algorithm using counting sort.
     * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
     * Could you come up with a one-pass algorithm using only constant space?
     *
     * @see <a href="https://leetcode.com/problems/sort-colors/"/>
     */

    public static void main(String[] args) {
        int nums[] = new int[]{1,1,2,2};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sortColors(int[] nums) {


        /**
         *      int i = -1;
         *         int j = -1;
         *         int k = -1;
         *         for(int p = 0; p < nums.length; p ++){
         *             //根据第i个数字，挪动0~i-1串。
         *             if(nums[p] == 0)
         *             {
         *                 nums[++k] = 2;    //2往后挪
         *                 nums[++j] = 1;    //1往后挪
         *                 nums[++i] = 0;    //0往后挪
         *             }
         *             else if(nums[p] == 1)
         *             {
         *                 nums[++k] = 2;
         *                 nums[++j] = 1;
         *             }
         *             else
         *                 nums[++k] = 2;
         *         }
         *
         *
         *         神仙代码  >..<  !!!!!!
         */




        //固定住left和right位置  然后遍历i 目的是将0移动到left   2移动到right
        int left = 0;
        int right = nums.length-1;
        int i =  0;
        int temp;
        while (i<=right){
            //碰到0   与left 互换位置
            if (nums[i]==0){
                temp = nums[left];
                nums[left]= nums[i];
                nums[i] = temp;
                //左边放好0 右移一位
                left++;
                //因为  i以前的数都判断过了 所以i 右移
                i++;
            }else if (nums[i]==1){
                //如果是1忽略   继续找 0 或 2
                i++;
            }else {
                //找到2 放到最右边  因为不确定换过去的是什么数  所以 i位置不变
                temp = nums[right];
                nums[right] = nums[i];
                nums[i] = temp;
                right--;
            }

        }

    }

}
