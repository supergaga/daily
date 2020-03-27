package com.leetcode.daliy;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author TSN
 * @date 2020/3/27
 * @Description
 */
public class SoutTree {
    public static void main(String[] args) {
        int[] a = new int[]{1,3,2};
    }
    public static  int[] reversePrint(ListNode head) {
        LinkedList<Integer> list = new LinkedList<>();
        while (head!=null){
            list.add(head.value);
            head = head.next;
        }
        Collections.reverse(list);
        int[] result = new int[list.size()];
        for (int i = 0; i <result.length; i++) {
            result[i]= list.get(i+1);
        }
        return result;
    }
}
