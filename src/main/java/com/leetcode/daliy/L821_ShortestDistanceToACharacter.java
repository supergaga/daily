package com.leetcode.daliy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TSN
 * @date 2019/2/12
 * @Description
 */
public class L821_ShortestDistanceToACharacter {
    /**
     * Given a string S and a character C, return an array of integers representing the shortest distance from the character C in the string.
     *
     * Example 1:
     *
     * Input: S = "loveleetcode", C = 'e'
     * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
     */

    public static void main(String[] args) {
        String target = "loveleetcode";

        System.out.println(Arrays.toString(shortestToChar(target,'e')));
    }
    public static  int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        List<Integer> cValue = new ArrayList<>();
        //记录下C每次出现的下角标
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C){
                cValue.add(i);
            }
        }

        for (int i = 0; i < S.length(); i++) {
            //如果等于C  相距为0
            if (S.charAt(i) == C){
                result[i]=0;
            }else {
                //找到跟所有C相距最小的距离
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < cValue.size(); j++) {
                    min = Math.min(min,Math.abs(i-cValue.get(j)));
                }
                result[i] = min;
            }
        }
        return result;


    }
}
