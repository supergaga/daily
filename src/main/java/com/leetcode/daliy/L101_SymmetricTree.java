package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/29
 * @Description
 */
public class L101_SymmetricTree {
    /**
     * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
     *
     * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
     *
     *     1
     *    / \
     *   2   2
     *  / \ / \
     * 3  4 4  3
     * But the following [1,2,2,null,3,null,3] is not:
     *     1
     *    / \
     *   2   2
     *    \   \
     *    3    3
     * Note:
     * Bonus points if you could solve it both recursively and iteratively.
     *
     * @see <a href="https://leetcode.com/problems/symmetric-tree/"/>
     */

    public static void main(String[] args) {

    }

    public static boolean isSymmetric(TreeNode root) {
        //根节点  左右节点都不是null
        if (root !=null && root.left != null && root.right != null){
            //如果左右节点的值相等 再递归向下判断  否则返回false
            if (root.left.val == root.right.val){
                return  checkTree(root.left, root.right);
            }
            return false;
        //如果 根节点的左右都是null   肯定是对称的
        }else if (root !=null && root.left == null && root.right == null){
            return true;
        // 根节点是null   也是对称的
        }else if (root == null){
            return true;
        }
        return false;
    }

    private static boolean checkTree(TreeNode left, TreeNode right) {
        //如果左右不是null  并且值相等
        if (left != null && right !=null && left.val == right.val){
            //判断 这个节点下边的节点 两个边 和两个里是否相等   向下一直递归
            return checkTree(left.left,right.right)
                    && checkTree(left.right,right.left);
        //如果是null 也是对称的 且不用向下再判断
        }else if (left ==null && right == null ){
            return true;
        }
        //其中一个是null 返回false
        return false;
    }


}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
