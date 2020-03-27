package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2020/3/27
 * @Description
 */
public class MergeNode {
    public static void main(String[] args) {
        ListNode node1 =new ListNode(1);
        ListNode node2 =new ListNode(2);
        ListNode node3 =new ListNode(3);
        ListNode node4 =new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode znode1 =new ListNode(1);
        ListNode znode2 =new ListNode(2);
        ListNode znode3 =new ListNode(3);
        ListNode znode4 =new ListNode(4);
        znode1.next = znode2;
        znode2.next = znode3;
        znode3.next = znode4;
        mergeTwoLists(node1,znode1);

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        int v1 ,v2,vt;
        ListNode head = null ;

        ListNode temp = null;
        while(l1 != null || l2 != null){
            if (l1 == null){
                temp.next = l2;
                l2=null;
            }else if (l2 ==null){
                temp.next = l1;
                l1=null;
            }else{
                v1 = l1.value;
                v2 = l2.value;
                if (v1<=v2){
                    vt = v1;
                    l1=l1.next;
                }else{
                    vt =v2;
                    l2 =l2.next;
                }
                if(head == null){
                    head = new ListNode(vt);
                    temp = head;
                }else{
                    temp.next = new ListNode(vt);
                    temp = temp.next;
                }
            }

        }
        return head;

    }
}
