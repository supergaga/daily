package com.leetcode.daliy;

import java.util.List;

/**
 * @author TSN
 * @date 2019/1/5
 * @Description
 */
public class L120_Triangle {
    /**
     * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
     *
     * For example, given the following triangle
     *
     * [
     *      [2],
     *     [3,4],
     *    [6,5,7],
     *   [4,1,8,3]
     * ]
     * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
     *
     * Note:
     *
     * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
     *
     * @see <a href="https://leetcode.com/problems/triangle/"/>
     */


    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0) return 0;

        int triszie = triangle.size();
        //  声明一个底部大小的数组  存贮每个位置到底的最小值
        int[] result = new int[triszie];
        //倒序来查找
        for(int i = triszie - 1; i >= 0; i--){
            for(int j = 0; j <= i; j++){
                if(i == triszie - 1){
                    //最后一排  第一个的值  此时位置为  result[0]
                    result[j] = triangle.get(i).get(j);
                }else {
                    //在最后一排的时候  result会被初始化为 最后一排本来的值 因为 result[j+1]为0

                    //遍历完最后一排 倒着遍历的话  每次都是 上一排 相同的位置 或者下个位置 最小值  加上当前位置的值 重新覆盖  result有数值的长度越来越小
                    //到 三角的尖上 就只剩一个了 直接返回result[0] 就行
                    result[j] = Math.min(result[j],result[j+1]) + triangle.get(i).get(j);
                }
            }
        }
        return result[0];
    }
}
