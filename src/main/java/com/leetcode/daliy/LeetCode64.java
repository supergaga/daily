package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/14
 * @Description
 */
public class LeetCode64 {
    /**
     * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
     *
     * Note: You can only move either down or right at any point in time.
     *
     * Example:
     *
     * Input:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * Output: 7
     * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
     *
     * @see <a href="https://leetcode.com/problems/minimum-path-sum/" />
     */

    public static void main(String[] args) {
        int num[][] = new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(num.length);

        System.out.println(minPathSum(num));
    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1){
            return 0;
        }
        //行数
        int rows = grid.length;
        //列数
        int cols = grid[0].length;
        //声明一个新的二维数组
        int[][] result = new int[rows][cols];
        // 左上角的数值
        result[0][0] = grid[0][0];
        // 第一行所有的距离值
        for(int i = 1; i < cols; i++){
            result[0][i] = result[0][i - 1] + grid[0][i];
        }
        // 第一列的距离值
        for(int i = 1; i < rows; i++){
            result[i][0] = result[i - 1][0] + grid[i][0];
        }
        // 计算每行空位的值   从1，1位置开始
        // 上边位置和左边位置都是最小距离 选一个小的 加上 当前位置的值 就是到当前位置的最小距离
        //  每个最小最优解 放大以后就是最优解
        for(int i = 1; i < rows; i++){
            for( int j = 1; j < cols; j++){
                result[i][j] = Math.min(result[i-1][j], result[i][j-1]) + grid[i][j];
            }
        }
        // 角落的就是最小距离
        return result[rows - 1][cols - 1];
    }
}
