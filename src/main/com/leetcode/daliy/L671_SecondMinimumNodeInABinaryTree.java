package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2019/1/10
 * @Description
 */
public class L671_SecondMinimumNodeInABinaryTree {
    /**
     * Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly two or zero sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.
     *
     * Given such a binary tree, you need to output the second minimum value in the set made of all the nodes' value in the whole tree.
     *
     * If no such second minimum value exists, output -1 instead.
     *
     * Example 1:
     * Input:
     *     2
     *    / \
     *   2   5
     *      / \
     *     5   7
     *
     * Output: 5
     * Explanation: The smallest value is 2, the second smallest value is 5.
     * Example 2:
     * Input:
     *     2
     *    / \
     *   2   2
     *
     * Output: -1
     * Explanation: The smallest value is 2, but there isn't any second smallest value.
     *
     * @see <a href="https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/"/>
     */
    public static void main(String[] args) {

    }
    public static int findSecondMinimumValue(TreeNode root) {
        // 有两个 或者0个 子节点
        if (root == null )return -1;
        if (root.left==null && root.right == null ) return -1;
        // 定义左右节点的值
        int left = root.left.val;
        int right = root.right.val;

        //两个子节点 大于等于根节点  所以越往下越大 或者都相等
        //拿第二层来考虑 如果不是等于的话 不需要往下找  本层两个较小值就是第二小  就是 两个都不是-1  选一个小的
        //  所以只有相等的 才有找下去的必要   而找到最后肯定会到最底层   这样min就会返回-1 只要左右两边不是同时 都是-1 那另一个就是第二小的
        if (root.left.val == root.val){
            left = findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val){
            right = findSecondMinimumValue(root.right);
        }

        if (left!= -1 && right != -1) {
            return Math.min(left,right);
        }else if (left==-1){
            return right;
        }else {
            return left;
        }


    }
}
