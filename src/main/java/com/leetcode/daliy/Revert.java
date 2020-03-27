package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2020/3/27
 * @Description
 */
public class Revert {
    public static void main(String[] args) {

    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;


        ListNode temp = null;

        while (current!=null){
            temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }
}
class ListNode{
    int value;
    ListNode next;
}
