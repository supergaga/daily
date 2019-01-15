package com.leetcode.daliy;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author TSN
 * @date 2019/1/15
 * @Description
 */
public class L905_SortArrayByParity {
    /**
     * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
     *
     * You may return any answer array that satisfies this condition.
     *
     *
     *
     * Example 1:
     *
     * Input: [3,1,2,4]
     * Output: [2,4,3,1]
     * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
     *
     *
     * Note:
     *
     * 1 <= A.length <= 5000
     * 0 <= A[i] <= 5000
     *
     * @see <a href="https://leetcode.com/problems/sort-array-by-parity/"/>
     */

    public static void main(String[] args) {
        int nums[] =  new int[]{3,1,2,4};
        System.out.println(Arrays.toString(sortArrayByParity(nums)));
    }

    public static int[] sortArrayByParity(int[] A) {
        //双指针
        int start  = 0;
        int end = A.length-1;

        while (start<end){
            //如果开始的是偶数  那么开始指针移动  直到有一个不是的
            if (A[start] % 2 ==0){
                start++;
                continue;
            }
            //找到一个不是奇数的
            if (A[end] % 2 ==1){
                end--;
                continue;
            }
            //交换位置
            int temp =0;
            temp = A[start];
            A[start] = A[end];
            A[end] = temp;
        }
        return A;
    }

}
