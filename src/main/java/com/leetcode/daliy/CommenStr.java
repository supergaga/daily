package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2020/3/27
 * @Description 公共子序列
 */
public class CommenStr {
    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";
        System.out.println(get(text1, text2));
    }

    public static int get(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return 0;
        }
        int lengthA = text1.length();
        int lengthB = text2.length();
        if (lengthA == 0 || lengthB == 0) {
            return 0;
        }
        int[][] dp = new int[lengthA + 1][lengthB + 1];
        for (int i = 1; i <= lengthA; i++) {
            for (int j = 1; j <= lengthB; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[lengthA][lengthB];
    }
}
