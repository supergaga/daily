package com.leetcode.daliy;

import java.util.*;

/**
 * @author TSN
 * @date 2020/3/27
 * @Description
 */
public class TopK {
    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,4,4,5,6,7,8,9};
        System.out.println(Arrays.toString(topKFrequent(a, 3).toArray()));
    }
    public static List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap();
        for (int num : nums) {
            count.put(num,count.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> integers = new PriorityQueue<>(Comparator.comparing(count::get));
        for (Integer integer : count.keySet()) {
            integers.add(integer);
            if (integers.size()>k) {
                integers.poll();
            }
        }
        LinkedList<Integer> objects = new LinkedList<>();
        while (!integers.isEmpty()){
            objects.add(integers.poll());
        }
        Collections.reverse(objects);
        return objects;


    }
}
