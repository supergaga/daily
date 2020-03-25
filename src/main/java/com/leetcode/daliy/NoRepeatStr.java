package com.leetcode.daliy;

import java.util.Arrays;
import java.util.HashMap;

public class NoRepeatStr {

    public static void main(String[] args) {
        String str = "abba";
        System.out.println(getLength(str));
    }

    private static int getLength(String s) {

        int length = s.length();
        if (length==0) {
            return 0;
        }
        int left=0;
        int max =0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(s.charAt(i))) {
                left =Math.max(left,map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);


            max = Math.max(max,i-left+1);
        }
        return max;
    }


}
