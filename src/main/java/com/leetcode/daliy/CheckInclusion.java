package com.leetcode.daliy;

import java.util.Arrays;

/**
 * @author TSN
 * @date 2020/3/26
 * @Description
 */
public class CheckInclusion {
    public static void main(String[] args) {
        String ab = "aab";
        String abac = "ccabacc";
        System.out.println(checkInclusion(ab, abac));
    }

    public static boolean checkInclusion(String s1, String s2) {
        int lengthA = s1.length();
        int lengthB = s2.length();
        if (lengthA == 0 || lengthB == 0 || lengthA > lengthB) {
            return false;
        }

        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < lengthA; i++) {
            a[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < lengthB; i++) {

            if (i >= lengthA) {
                --b[s2.charAt(i-lengthA) - 'a'];
            }

            b[s2.charAt(i) - 'a']++;
            if (Arrays.equals(a, b)) {
                return true;
            }
        }
        return false;
    }

}
