package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2019/1/16
 * @Description
 */
public class L680_ValidPalindromeII {
    /**
     * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
     *
     * Example 1:
     * Input: "aba"
     * Output: True
     * Example 2:
     * Input: "abca"
     * Output: True
     * Explanation: You could delete the character 'c'.
     *
     * @see <a href="https://leetcode.com/problems/valid-palindrome-ii/"/>
     */
    public static void main(String[] args) {
        String a = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        System.out.println(validPalindrome(a));
    }
    public static boolean validPalindrome(String s) {

        char[] chars = s.toCharArray();
        int start =0;
        int end = chars.length-1;
        while (start < end){
            if (chars[start] == chars[end]){
                start++;
                end--;
            }else {
               return isPalindrome(chars,start+1,end) || isPalindrome(chars,start,end-1);
            }
        }
        return true;


    }

    private static boolean isPalindrome(char[] chars, int i, int end) {
        while (i<end){
            if (chars[i++] != chars[end--]){
                return false;
            }
        }
        return true;
    }
}
