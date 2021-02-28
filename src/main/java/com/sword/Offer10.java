package com.sword;


/**
 * @author TSN
 * @date 2020/12/8
 * @Description
 */
public class Offer10 {

  public static void main(String[] args) {

    System.out.println(numWays(7));
  }

  public static int numWays(int n) {
    if(n<2) return 1;
    if(n==2) return 2;
    int[] dp = new int[2];
    dp[0] =1;
    dp[1] =2;
    int temp;
    for (int i = 3; i <= n; i++) {
      temp = (dp[0]+dp[1])%1000000007;
      dp[0] = dp[1];
      dp[1] = temp;
    }
    return dp[1];

  }

}
