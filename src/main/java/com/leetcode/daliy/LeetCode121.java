package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/25
 * @Description
 */
public class LeetCode121 {
    /**
     *
     * Say you have an array for which the ith element is the price of a given stock on day i.
     *
     * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
     *
     * Note that you cannot sell a stock before you buy one.
     *
     * Example 1:
     *
     * Input: [7,1,5,3,6,4]
     * Output: 5
     * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
     *              Not 7-1 = 6, as selling price needs to be larger than buying price.
     * Example 2:
     *
     * Input: [7,6,4,3,1]
     * Output: 0
     * Explanation: In this case, no transaction is done, i.e. max profit = 0.
     *[1,2,4,2,5,7,2,4,9,0,9]
     * @see <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/"/>
     */

    public static void main(String[] args) {
        int num[] =  new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(num));
    }


    public static int maxProfit(int[] prices) {
        int max= 0;
        int i = 0;
        int j = 1;
        //边界条件
        while (i<prices.length-1 && j<prices.length ){
            //如果当前值小于下一个值
            if (prices[i]<prices[j]){
                //记录差值
                int temp = prices[j]-prices[i];
                // 取差值中最大的做记录
                max = max>temp ? max : temp;
                //下一天的指针下移
                j++;
            }else {
                //下一个值更小  传入第一个中进行比较
                i=j;
                j=i+1;
            }

        }
        return max;
    }


    /**
     *
     *
     *
     * var maxProfit = function(prices) {
     *     let maxProfit = 0;
     *     let potentialProfit = 0;
     *     let current = prices[0];
     *     let minPrice = prices[0];
     *
     *     for(let i = 1; i < prices.length; i++)
     *         {
     *             记录当前的值
     *             current = prices[i];
     *             如果当前值小于最小值 重新定义最小值
     *             if(current < minPrice) minPrice = current;
     *             否则 记录差值
     *             else potentialProfit = current - minPrice;
     *             找出 两者中的最大值返回
     *             maxProfit = Math.max(maxProfit, potentialProfit);
     *
     *
     *         }
     *     return maxProfit;
     *
     * };
     *
     */


}
