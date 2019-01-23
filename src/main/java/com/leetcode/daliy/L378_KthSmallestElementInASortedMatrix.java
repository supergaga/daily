package com.leetcode.daliy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TSN
 * @date 2019/1/22
 * @Description
 */
public class L378_KthSmallestElementInASortedMatrix {
    /**
     *Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
     *
     * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
     *
     * Example:
     *
     * matrix = [
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     *
     * return 13.
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ n2.
     *
     * @see <a href="https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/"/>
     */
    public static void main(String[] args) {
        int num[][] = new int[][]{
                { 1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(kthSmallest(num,8));

    }
    public static int kthSmallest(int[][] matrix, int k) {
        //其实用的方法很蠢 就是  遍历到一个数组里面排序 然后取第几个
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int i1 = 0; i1 < matrix.length; i1++) {
                result.add(matrix[i][i1]);
            }
        }
        Integer[] rt = new Integer[result.size()];
        result.toArray(rt);
        Arrays.sort(rt);
        return rt[k-1];
    }
}
