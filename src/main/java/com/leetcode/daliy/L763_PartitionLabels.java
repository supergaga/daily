package com.leetcode.daliy;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TSN
 * @date 2019/1/3
 * @Description
 */
public class L763_PartitionLabels {
    /**
     * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
     *
     * Example 1:
     * Input: S = "ababcbacadefegdehijhklij"
     * Output: [9,7,8]
     * Explanation:
     * The partition is "ababcbaca", "defegde", "hijhklij".
     * This is a partition so that each letter appears in at most one part.
     * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
     * Note:
     *
     * S will have length in range [1, 500].
     * S will consist of lowercase letters ('a' to 'z') only.
     *
     * @see <a href="https://leetcode.com/problems/partition-labels/"/>
     */

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));

    }
    public static List<Integer> partitionLabels(String S) {

        List<Integer> returnList = new ArrayList<>();
            int result[] = new int[26];
            // 通过遍历 得到 每一个字母最后出现的位置
            for (int i = 0; i < S.length(); i++) {
                result[S.charAt(i) - 'a'] = i;
            }
            //定义起始位置
            int start = 0;
            //遍历整个数组
            while (start<S.length()){
                //初始化最后出现的位置
                int lastIndex = start;
                //开始把第一个元素最后出现的位置当边界  如果 直到这个边界 都没有找到超过的另一个超过边界的 那这个值加1就是长度值  如果超过了 换新边界
                for (int i = start; i < S.length() && i<=lastIndex; i++) {
                    //当前值 最后出现的位置
                    int currentIndex = result[S.charAt(i) - 'a'];
                    //如果大于现有边界则替换掉现有边界的值
                    if (currentIndex>lastIndex){
                        lastIndex = currentIndex;
                    }
                }
                //  当i不满足 <= lastIndex 说明 到这个位置 没有再大于他的了
                returnList.add(lastIndex-start+1);
                //重新定义下一个位置为开始位置
                start= lastIndex+1;
            }
            return returnList;
    }
}
