package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2020/3/27
 * @Description
 */
public class Replace {
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }
    public static String replaceSpace(String s) {
        if (s.equals(" ")) return "%20";
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == ' ') {
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();

    }
}
