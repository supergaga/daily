package com.leetcode.daliy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author TSN
 * @date 2019/1/7
 * @Description
 */
public class L290_WordPattern {
    /**
     * Given a pattern and a string str, find if str follows the same pattern.
     *
     * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
     *
     * Example 1:
     *
     * Input: pattern = "abba", str = "dog cat cat dog"
     * Output: true
     * Example 2:
     *
     * Input:pattern = "abba", str = "dog cat cat fish"
     * Output: false
     * Example 3:
     *
     * Input: pattern = "aaaa", str = "dog cat cat dog"
     * Output: false
     * Example 4:
     *
     * Input: pattern = "abba", str = "dog dog dog dog"
     * Output: false
     * Notes:
     * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
     *
     * @see <a href="https://leetcode.com/problems/word-pattern/"/>
     */
    public static void main(String[] args) {
        System.out.println(wordPattern("abb","dog cat cat"));
    }

    public static boolean wordPattern(String pattern, String str) {
        // 用空格分隔开
        String[] strings = str.split(" ");
        //长度不等 返回为false
        if (strings.length != pattern.length()) return false;
        //存放 pattern 的数据
        Map<Character,String> map = new HashMap<>();
        // 遍历 pattern
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            //如果 出现过
            if (map.containsKey(c)){
                // 看之前 出现这个值的时候对应str中的值 是否相等
                if (!map.get(c).equals(strings[i])) return false;
            }else {
                //如果没有出现 看 str中的值 是否在别的下面出现过
                if (map.containsValue(strings[i])) return false;
                //没在别的下面出现过  放入
                map.put(c,strings[i]);
            }

        }
        return true;

    }
}
