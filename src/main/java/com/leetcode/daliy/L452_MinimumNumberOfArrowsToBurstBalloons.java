package com.leetcode.daliy;

import java.util.Arrays;

/**
 * @author TSN
 * @date 2018/12/21
 * @Description
 */
public class L452_MinimumNumberOfArrowsToBurstBalloons {
    /**
     * There are a number of spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter and hence the x-coordinates of start and end of the diameter suffice. Start is always smaller than end. There will be at most 104 balloons.
     *
     * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps travelling up infinitely. The problem is to find the minimum number of arrows that must be shot to burst all balloons.
     *
     * Example:
     *
     * Input:
     * [[10,16], [2,8], [1,6], [7,12]]
     *
     * Output:
     * 2
     *
     * Explanation:
     * One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
     * @see <a href="https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/"/>
     */
    public static void main(String[] args) {

        int points[][] = new int[][]{
                {10,16},
                {2,8},
                {1,6},
                {7,12}
        };
        System.out.println(findMinArrowShots(points));
    }


    public static int findMinArrowShots(int[][] points) {
        if(points.length == 0){return 0;}
        int output = 1;
         Arrays.sort(points,(x,y)->x[0] == y[0]?x[1]-y[1]:x[0]-y[0]);
        int start = points[0][1];
        for(int i = 1;i < points.length;i++){
            if(points[i][0] <= start){
                if(points[i][1]<start)
                start = points[i][1];
            }else {
                output++;
                start = points[i][1];
            }
        }
        return output;

    }

}
