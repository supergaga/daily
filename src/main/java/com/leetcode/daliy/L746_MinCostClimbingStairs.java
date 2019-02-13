package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2019/2/13
 * @Description
 */
public class L746_MinCostClimbingStairs {
    /**
     * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
     *
     * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.
     *
     * Example 1:
     * Input: cost = [10, 15, 20]
     * Output: 15
     * Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
     * Example 2:
     * Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
     * Output: 6
     * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
     */
    public static void main(String[] args) {
//        int[] cost = new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int[] cost = new int[]{0,0,0,1};
        System.out.println(minCostClimbingStairs(cost));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        if (length<=2) return 0;
        int[] dp = new int[length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < length; i++) {
            //  这个题 描述有问题  这个if  判断的是最后一步 如果两步登顶 是要算最后一步的值的  如果是一步登顶 是不用算最后一步的值的
            if (i ==  length-1){
                dp[i] = Math.min(dp[i-1],dp[i-2]+cost[i]);
            }else {
                dp[i] = Math.min(dp[i-1],dp[i-2])+cost[i];
            }
        }
        return dp[length-1];

    }

}
