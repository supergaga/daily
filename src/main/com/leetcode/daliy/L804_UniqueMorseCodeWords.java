package com.leetcode.daliy;

import java.util.HashSet;
import java.util.Set;

/**
 * @author TSN
 * @date 2019/1/21
 * @Description
 */
public class L804_UniqueMorseCodeWords {
    /**
     * International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
     *
     * For convenience, the full table for the 26 letters of the English alphabet is given below:
     *
     * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
     * Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cba" can be written as "-.-..--...", (which is the concatenation "-.-." + "-..." + ".-"). We'll call such a concatenation, the transformation of a word.
     *
     * Return the number of different transformations among all words we have.
     *
     * Example:
     * Input: words = ["gin", "zen", "gig", "msg"]
     * Output: 2
     * Explanation:
     * The transformation of each word is:
     * "gin" -> "--...-."
     * "zen" -> "--...-."
     * "gig" -> "--...--."
     * "msg" -> "--...--."
     *
     * There are 2 different transformations, "--...-." and "--...--.".
     * Note:
     *
     * The length of words will be at most 100.
     * Each words[i] will have length in range [1, 12].
     * words[i] will only consist of lowercase letters.
     *
     * @see <a href = "https://leetcode.com/problems/unique-morse-code-words/"/>
     */
    public static void main(String[] args) {
        String hello[] = new String[]{"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(hello));
    }
    public static int uniqueMorseRepresentations(String[] words) {
        String[] MORSE = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."} ;

        //创建一个不能存放重复数据的list
        Set<String> seen = new HashSet<>() ;
        //遍历words
        for(String word : words) {
            StringBuilder code = new StringBuilder() ;
            for (char c : word.toCharArray()) {
                //将字母替换成摩斯码
                code.append(MORSE[c - 'a']) ;
            }
            //重复的放不进去
            seen.add(code.toString()) ;
        }
        return seen.size() ;



    }
}
