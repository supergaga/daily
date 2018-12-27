package com.leetcode.daliy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author TSN
 * @date 2018/12/15
 * @Description
 */
public class L347_TopKFrequentElements {

    /**
     * Given a non-empty array of integers, return the k most frequent elements.
     *
     * Example 1:
     *
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     *
     * Input: nums = [1], k = 1
     * Output: [1]
     * Note:
     *
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     *
     * @see <a href="https://leetcode.com/problems/top-k-frequent-elements/" />
     */

    public static void main(String[] args) {
        int num[] =  new int[]{1,1,1,2,2,3};

        topKFrequent(num,1).forEach(System.out::print);


    }

    public static List<Integer> topKFrequent(int[] nums, int k) {

        //放入map中
        Map<Integer,Integer> map = new HashMap<>();
        //map  key记录数值  value  记录出现次数
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num,map.get(num)+1);
            else
                map.put(num,1);
        }
        // 桶排序
        List<Integer>[] bucker = new List[nums.length+1];
        //遍历map的key
        for (Integer key : map.keySet()) {
            //将出现次数做桶的下角标 放入桶中
            int count = map.get(key);
            if (bucker[count] ==null) bucker[count] = new ArrayList<>();
            bucker[count].add(key);
        }
        //倒序取出   ：）
        List<Integer> result = new ArrayList<>();
        for (int i = nums.length; i > 0; i--) {
            if (bucker[i] != null && result.size()<k)
                result.addAll(bucker[i]);
        }
        return result;
    }
}
