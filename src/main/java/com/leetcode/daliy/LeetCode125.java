package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/17
 * @Description
 */
public class LeetCode125 {
    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     *
     * Note: For the purpose of this problem, we define empty string as valid palindrome.
     *
     * Example 1:
     *
     * Input: "A man, a plan, a canal: Panama"
     * Output: true
     * Example 2:
     *
     * Input: "race a car"
     * Output: false
     * @see <a href="https://leetcode.com/problems/valid-palindrome/"/>
     */

    public static void main(String[] args) {

        String s = "race a car";
        System.out.println(isPalindrome(s));

    }
    public static boolean isPalindrome(String s) {
        //变小写
        s = s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        //遍历
        for (char aChar : chars) {

            boolean isLetter = (int) aChar >= 97 && (int) aChar <= 122;
            boolean isNumber = (int) aChar >= 48 && (int) aChar <= 57;
            //将字母或者数字收集起来
            if (isNumber||isLetter){
                sb.append(aChar);
            }
        }
        //新数组
        char[] newArray = sb.toString().toCharArray();

        int start = 0;
        int end = newArray.length-1;
        //循环看头尾是否相同
        while (start<end){

            if (newArray[start] == newArray[end]){
                start++;
                end--;
            }else {
                return false;
            }

        }
        return true;
    }

}
