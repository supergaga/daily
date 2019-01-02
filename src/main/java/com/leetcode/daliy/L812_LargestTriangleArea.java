package com.leetcode.daliy;

import java.util.Arrays;

/**
 * @author TSN
 * @date 2019/1/2
 * @Description
 */
public class L812_LargestTriangleArea {
    /**
     * You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.
     *
     * Example:
     * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
     * Output: 2
     * Explanation:
     * The five points are show in the figure below. The red triangle is the largest.
     *
     *
     * Notes:
     *
     * 3 <= points.length <= 50.
     * No points will be duplicated.
     *  -50 <= points[i][j] <= 50.
     * Answers within 10^-6 of the true value will be accepted as correct.
     *
     * @see <a href="https://leetcode.com/problems/largest-triangle-area/"/>
     *
     */
    public static void main(String[] args) {
        int points[][] = new int[][]{
                {0,0},
                {0,1},
                {1,0},
                {0,2},
                {2,0},
        };
        System.out.println(largestTriangleArea(points));

    }
    public static double largestTriangleArea(int[][] points) {
    //就是三角公式  ：）
        double are = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                for (int k = 0; k < points.length; k++) {
                     are = Math.max(are,0.5*(points[k][0]*points[j][1]+points[i][0]*points[k][1]+points[j][0]*points[i][1]
                     - points[k][1]*points[j][0]-points[j][1]*points[i][0]-points[k][0]*points[i][1]
                     ));
                }

            }
        }
        return are;
    }
}
