package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/27
 * @Description
 */
public class L744_FindSmallestLetterGreaterThanTarget {

    /**
     *
     * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.
     *
     * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
     *
     * Examples:
     * Input:
     * letters = ["c", "f", "j"]
     * target = "a"
     * Output: "c"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "c"
     * Output: "f"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "d"
     * Output: "f"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "g"
     * Output: "j"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "j"
     * Output: "c"
     *
     * Input:
     * letters = ["c", "f", "j"]
     * target = "k"
     * Output: "c"
     * Note:
         * letters has a length in range [2, 10000].
         * letters consists of lowercase letters, and contains at least 2 unique letters.
         * target is a lowercase letter.
     *
     *
     */

    public static void main(String[] args) {
        char chars[] = new char[]{'c', 'f', 'j'};
        System.out.println(nextGreatestLetter(chars,'j'));
    }
    public static char nextGreatestLetter(char[] letters, char target) {


        int start = 0, end = letters.length - 1;

        while(start + 1 < end) {
            int mid = start + (end - start) / 2;

            if(letters[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if(letters[start] > target) {
            return letters[start];
        } else if(letters[end] > target) {
            return letters[end];
        } else {
            return letters[0];
        }


    }

}
