package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2019/11/7
 * @Description
 */
public class L852 {
    public static void main(String[] args) {
        int a[] = new int[]{0, 1, 5, 9};
        int i = peakIndexInMountainArray(a);
        System.out.println(i);
    }

    public static int peakIndexInMountainArray(int[] A) {
//
//        for (int i = 0; i < A.length; i++) {
//            if (i==0 || A.length<3) continue;
//            if (A[i]>A[i+1] && A[i]>A[i-1]) {
//                return i;
//            }
//        }
//        return 0;

        int start = 0;
        int end = A.length - 1;
        while (start < end) {
            int mid = start + end + 1 >> 1;
            if (A[mid] < A[mid - 1]) {
                end = mid - 1;
            } else {
                start = mid;
            }
        }
        return start;
    }
}
