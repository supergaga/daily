package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2019/3/6
 * @Description
 */
public class L168_ExcelSheetColumnTitle {
    /**
     * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
     *
     * For example:
     *
     *     1 -> A
     *     2 -> B
     *     3 -> C
     *     ...
     *     26 -> Z
     *     27 -> AA
     *     28 -> AB
     *     ...
     * Example 1:
     *
     * Input: 1
     * Output: "A"
     * Example 2:
     *
     * Input: 28
     * Output: "AB"
     * Example 3:
     *
     * Input: 701
     * Output: "ZY"
     * <a href="https://leetcode.com/problems/excel-sheet-column-title/"/>
     */

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));

    }


    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            n--;
            char c = (char)(n % 26 + 'A');
            sb.append(c);
            n /= 26;
        }
        return sb.reverse().toString();
    }

}
