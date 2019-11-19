package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2019/11/11
 * @Description
 */
public class L162 {
    public static void main(String[] args) {
        int a[] = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(a));
    }

    public static int findPeakElement(int[] nums) {

//        for (int i = 0; i < nums.length-1; i++) {
//            if (nums[i+1]<nums[i]){
//                return i;
//            }
//        }aaa
//        return nums.length-1;zzz
//            }cccc
//        }
//        B:bbbb A:again
//
//        A:aaa  :again
//        C: hellokkkk

//ddddd
//  masterA:99999
//ddddd
//        A:aaa
//        A

//cccc
//        A


//  masterA:99999
//        A:aaa
//cccc

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + end + 1 >> 1;
            if (nums[mid] < nums[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        //A->1
        // B ->1
        return start;
    }
//devB->1
//devB->2



}
