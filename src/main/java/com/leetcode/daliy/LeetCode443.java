package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/13
 * @Description
 */
public class LeetCode443 {


    /**
     * Given an array of characters, compress it in-place.
     *
     * The length after compression must always be smaller than or equal to the original array.
     *
     * Every element of the array should be a character (not int) of length 1.
     *
     * After you are done modifying the input array in-place, return the new length of the array.
     *
     *
     * Follow up:
     * Could you solve it using only O(1) extra space?
     *
     *
     * Example 1:
     *
     * Input:
     * ["a","a","b","b","c","c","c"]
     *
     * Output:
     * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
     *
     * Explanation:
     * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
     *
     *
     * Example 2:
     *
     * Input:
     * ["a"]
     *
     * Output:
     * Return 1, and the first 1 characters of the input array should be: ["a"]
     *
     * Explanation:
     * Nothing is replaced.
     *
     *
     * Example 3:
     *
     * Input:
     * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
     *
     * Output:
     * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
     *
     * Explanation:
     * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
     * Notice each digit has it's own entry in the array.
     *
     *
     * Note:
     *
     * All characters have an ASCII value in [35, 126].
     * 1 <= len(chars) <= 1000.
     *
     * @see <a href="https://leetcode.com/problems/string-compression/"/>
     * @param args
     */

    public static void main(String[] args) {
        char num[] = new char[]{1, 1, 2, 2, 2, 3, 3, 3, 3};
        System.out.println(Solution.compress(num));
    }


    static class Solution {
        public  static int  compress(char[] chars) {


            if (chars.length == 0) return 0;

            StringBuilder sb = new StringBuilder();
            char cur = chars[0];
            int sum = 1;
            for (int i = 1; i <= chars.length; i++) {
                if (i < chars.length && chars[i] == cur) {
                    sum++;
                } else {
                    sb.append(String.valueOf(cur));
                    if (sum > 1) {
                        sb.append(sum);
                    }
                    if (i < chars.length) {
                        cur = chars[i];
                        sum = 1;
                    }
                }
            }
            char[] compressChar = sb.toString().toCharArray();
            for (int i = 0; i < compressChar.length; i++) {
                chars[i] = compressChar[i];
            }
            return sb.length();


        }
    }
}
