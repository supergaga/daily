package com.leetcode.daliy;

import java.util.*;

/**
 * @author TSN
 * @date 2019/2/19
 * @Description
 */
public class L884_UncommonWordsFromTwoSentences {
    /**
     * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
     *
     * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
     *
     * Return a list of all uncommon words.
     *
     * You may return the list in any order.
     *
     *
     *
     * Example 1:
     *
     * Input: A = "this apple is sweet", B = "this apple is sour"
     * Output: ["sweet","sour"]
     * Example 2:
     *
     * Input: A = "apple apple", B = "banana"
     * Output: ["banana"]
     *
     *
     * Note:
     *
     * 0 <= A.length <= 200
     * 0 <= B.length <= 200
     * A and B both contain only spaces and lowercase letters.
     *
     * <a href="https://leetcode.com/problems/uncommon-words-from-two-sentences/"/>
     */

    public static void main(String[] args) {
        System.out.println(Arrays.toString(uncommonFromSentences("this apple is sweet","this apple is sour")));

    }

    public static String[] uncommonFromSentences(String A, String B) {
        String[] split = A.split(" ");
        Map<String,Integer> temp = new HashMap<>();
        for (String s : split) {
            if (temp.containsKey(s)){
                temp.put(s,temp.get(s)+1);
            }else {
                temp.put(s,1);
            }
        }
        String[] split1 = B.split(" ");
        for (String s : split1) {
            if (temp.containsKey(s)){
                temp.put(s,temp.get(s)+1);
            }else {
                temp.put(s,1);
            }
        }
        int i =0;

        List<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> stringIntegerEntry : temp.entrySet()) {
            if (stringIntegerEntry.getValue() ==1){
                result.add(stringIntegerEntry.getKey());
            }
        }
        return result.toArray(new String[result.size()]);

    }


    /**
     *         Map<String,Integer> map = new HashMap<>();
     *         Arrays.asList(A.split("")).forEach(x->map.merge(x,1,Math::addExact));
     *         Arrays.asList(B.split("")).forEach(x->map.merge(x,1,Math::addExact));
     *         return map.entrySet().stream().filter(x->x.getValue()==1).map(Map.Entry::getKey).toArray(String[]::new);
     */


    /**
     *  public static String[] uncommonFromSentences(String A, String B) {
     *         String[] split = A.split(" ");
     *         Map<String,Integer> temp = new HashMap<>();
     *         for (String s : split) {
     *             if (temp.containsKey(s)){
     *                 temp.put(s,temp.get(s)+1);
     *             }else {
     *                 temp.put(s,1);
     *             }
     *         }
     *         String[] split1 = B.split(" ");
     *         for (String s : split1) {
     *             if (temp.containsKey(s)){
     *                 temp.put(s,temp.get(s)+1);
     *             }else {
     *                 temp.put(s,1);
     *             }
     *         }
     *         int i =0;
     *
     *         for (Map.Entry<String, Integer> stringIntegerEntry : temp.entrySet()) {
     *             if (stringIntegerEntry.getValue() ==1){
     *                 i++;
     *             }
     *         }
     *         String[] result = new String[i];
     *         i =0;
     *         for (Map.Entry<String, Integer> stringIntegerEntry : temp.entrySet()) {
     *             if (stringIntegerEntry.getValue() ==1){
     *                 result[i++] = stringIntegerEntry.getKey();
     *             }
     *         }
     *
     *         return result;
     *
     *     }
     */

}
