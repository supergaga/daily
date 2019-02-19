package com.leetcode.daliy;

import java.util.*;

/**
 * @author TSN
 * @date 2019/2/19
 * @Description
 */
public class L784_LetterCasePermutation {
    /**
     * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
     *
     * Examples:
     * Input: S = "a1b2"
     * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
     *
     * Input: S = "3z4"
     * Output: ["3z4", "3Z4"]
     *
     * Input: S = "12345"
     * Output: ["12345"]
     * Note:
     *
     * S will be a string with length between 1 and 12.
     * S will consist only of letters or digits.
     *
     * <a href="https://leetcode.com/problems/letter-case-permutation/"/>
     */

    public static void main(String[] args) {

    }

    public static List<String> letterCasePermutation(String S) {
        char[] arr = S.toCharArray();
        Set<char[]> permutations = new HashSet<>();
        permutations.add(new char[arr.length]);

        for (int i = 0; i < arr.length; i++) {
            char a = arr[i];
            if (Character.isLetter(a)) {
                if (Character.isUpperCase(a)) {
                    Set<char[]> newOnes = new HashSet<>();
                    for (char[] inner : permutations) {
                        char[] copy = Arrays.copyOf(inner, inner.length);
                        inner[i] = a;
                        copy[i] = Character.toLowerCase(a);
                        newOnes.add(copy);
                    }
                    permutations.addAll(newOnes);
                }
                else {
                    Set<char[]> newOnes = new HashSet<>();
                    for (char[] inner : permutations) {
                        char[] copy = Arrays.copyOf(inner, inner.length);
                        inner[i] = a;
                        copy[i] = Character.toUpperCase(a);
                        newOnes.add(copy);
                    }
                    permutations.addAll(newOnes);
                }

            } else {
                for (char[] inner : permutations) {
                    inner[i] = a;
                }
            }
        }
        List<String> toReturn = new ArrayList<>();
        for (char[] arrs : permutations) {
            toReturn.add(new String(arrs));
        }
        return toReturn;

    }
}
