package com.leetcode.daliy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TSN
 * @date 2019/1/22
 * @Description
 */
public class L187_RepeatedDNASequences {
    /**
     * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
     *
     * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
     *
     * Example:
     *
     * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
     *
     * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
     */

    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println(findRepeatedDnaSequences(s));

    }
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        //前置条件
        if (null == s || s.length()<=10) return result;
        //用map来存储
        Map<String,Integer> map = new HashMap<>();
        // 遍历
        for (int i = 0; i <= s.length()-10; i++) {
            //每次取当前坐标向下的10个
            String substring = s.substring(i, i + 10);
            //如果map里面存在  证明已经出现过
            if (map.containsKey(substring)){
                //判断是不是第一次放入 result  避免 再出现以后再放一次
                if (map.get(substring) ==1){
                    //修改value  避免下次再放入result
                    map.replace(substring,1,-1);
                    result.add(substring);
                }
            }else {
                //放入map
                map.put(substring,1);
            }

        }
        return result;

    }

    /**
     * 没看懂的大神代码
     *  Set<Integer> words = new HashSet<>();
     *     Set<Integer> doubleWords = new HashSet<>();
     *     List<String> rv = new ArrayList<>();
     *     char[] map = new char[26];
     *     //map['A' - 'A'] = 0;
     *     map['C' - 'A'] = 1;
     *     map['G' - 'A'] = 2;
     *     map['T' - 'A'] = 3;
     *
     *     for(int i = 0; i < s.length() - 9; i++) {
     *         int v = 0;
     *         for(int j = i; j < i + 10; j++) {
     *             v <<= 2;
     *             v |= map[s.charAt(j) - 'A'];
     *         }
     *         if(!words.add(v) && doubleWords.add(v)) {
     *             rv.add(s.substring(i, i + 10));
     *         }
     *     }
     *     return rv;
     */
}
