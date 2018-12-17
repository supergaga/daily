package com.leetcode.daliy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TSN
 * @date 2018/12/17
 * @Description
 */
public class LeetCode451 {

    /**
     *
     *
     * Given a string, sort it in decreasing order based on the frequency of characters.
     *
     * Example 1:
     *
     * Input:
     * "tree"
     *
     * Output:
     * "eert"
     *
     * Explanation:
     * 'e' appears twice while 'r' and 't' both appear once.
     * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
     * Example 2:
     *
     * Input:
     * "cccaaa"
     *
     * Output:
     * "cccaaa"
     *
     * Explanation:
     * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
     * Note that "cacaca" is incorrect, as the same characters must be together.
     * Example 3:
     *
     * Input:
     * "Aabb"
     *
     * Output:
     * "bbAa"
     *
     * Explanation:
     * "bbaA" is also a valid answer, but "Aabb" is incorrect.
     * Note that 'A' and 'a' are treated as two different characters.
     *
     * @see  <a href="https://leetcode.com/problems/sort-characters-by-frequency/"/>
     *
     */

    public static void main(String[] args) {
        String input = "aaaccc";
        String s = frequencySort(input);
        System.out.println(s);

    }

    public static String frequencySort(String s) {

        char[] chars = s.toCharArray();
        //将数组放入map中 value是出现次数
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : chars) {
            if (map.containsKey(aChar)){
                map.put(aChar,map.get(aChar)+1);
            }else {
                map.put(aChar,1);
            }
        }
        //桶排序
        List<Character>[] lists = new List[chars.length+1];
        for (Character character : map.keySet()) {
            Integer count = map.get(character);
            if (null == lists[count]) lists[count] =  new ArrayList<>();
            lists[count].add(character);
        }
        StringBuilder sb = new StringBuilder();
        //倒序取出
        for (int i = chars.length; i >0; i--) {
            if (lists[i] != null ){
                //单个的 直接拼接就行
                if (lists[i].size()==1){
                    for (int j = 0; j < i; j++) {
                        lists[i].forEach(x->sb.append(x));
                    }
                }else {
                    //多个出现相同个数的  要再次遍历
                    List<Character> list = lists[i];

                    for (Character character : list) {
                        for (int j = 0; j < i; j++) {
                            sb.append(character);
                        }
                    }
                }
            }
        }


        return String.valueOf(sb);

    }

}
