package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/14
 * @Description
 */
public class LeetCode108 {
    /**
     * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
     *
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     *
     * Example:
     *
     * Given the sorted array: [-10,-3,0,5,9],
     *
     * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
     *
     *       0
     *      / \
     *    -3   9
     *    /   /
     *  -10  5
     *
     *
     * @see <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/"/>
     * @param args
     */
    public static void main(String[] args) {
        int nums[] = new int[]{-10,-3,0,5,9};
        TreeNode treeNode = sortedArrayToBST(nums);
        System.out.println(treeNode);
    }


    public static TreeNode sortedArrayToBST(int[] nums) {
        return array2Tree(nums,0,nums.length-1);

    }

    private static TreeNode array2Tree(int[] nums,int left,int right){
        if (left>right) return null;
        //基本就是2分+递归
        int mid = (right + left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left =  array2Tree(nums,left,mid-1);
        root.right = array2Tree(nums,mid+1,right);
        return root;
    }


}

/**
 * Definition for a binary tree node.
 */
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
