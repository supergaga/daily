package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/29
 * @Description
 */
public class L58_LengthOfLastWord {
    /**
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
     *
     * If the last word does not exist, return 0.
     *
     * Note: A word is defined as a character sequence consists of non-space characters only.
     *
     * Example:
     *
     * Input: "Hello World"
     * Output: 5
     *
     * @see <a href="https://leetcode.com/problems/length-of-last-word/"/>
     */
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }

    public static int lengthOfLastWord(String s) {

        int  result =0 , i = s.length()-1;

        //不要去考虑大小写之类的  就从后往前遍历 如果是空格就跳过  不是空格 就+1  最后返回result就行
        while (i>=0 && s.charAt(i) == ' '){
            i--;
        }
        while (i>=0 && s.charAt(i) != ' '){
            i--;
            result++;
        }
        return result;
    }

}
