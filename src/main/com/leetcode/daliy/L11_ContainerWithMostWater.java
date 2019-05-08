package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/14
 * @Description
 */
public class L11_ContainerWithMostWater {
    /**
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
     *
     * Note: You may not slant the container and n is at least 2.
     *
     *
     *
     *
     *
     * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
     *
     *
     *
     * Example:
     *
     * Input: [1,8,6,2,5,4,8,3,7]
     * Output: 49
     * @see <a href="https://leetcode.com/problems/container-with-most-water/"/>
     */


    public static void main(String[] args) {
        int num[] = new int[]{1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(num));
    }

    private static int maxArea(int[] height) {


        int start = 0;
        int end = height.length -1;
        int maxSize = 0;
        int result =0;
        //从两边分别开始
        while (start<end){
            //长度
            int length = end-start;
            //装水多少取决于最短的一个数 短的数往中间移动一个位置
            if (height[start]>height[end]){
                maxSize = height[end] * length;
                end--;
            }else {
                maxSize = height[start] * length;
                start++;
            }
            //记录每次移动后的结果  result保存最大值
            if (maxSize>result){
                result = maxSize;
            }

        }
        return result;

    }


}
