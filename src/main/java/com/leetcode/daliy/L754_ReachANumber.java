package com.leetcode.daliy;

/**
 * @author TSN
 * @date 2018/12/30
 * @Description
 */
public class L754_ReachANumber {
    /**
     * You are standing at position 0 on an infinite number line. There is a goal at position target.
     *
     * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
     *
     * Return the minimum number of steps required to reach the destination.
     *
     * Example 1:
     * Input: target = 3
     * Output: 2
     * Explanation:
     * On the first move we step from 0 to 1.
     * On the second step we step from 1 to 3.
     * Example 2:
     * Input: target = 2
     * Output: 3
     * Explanation:
     * On the first move we step from 0 to 1.
     * On the second move we step  from 1 to -1.
     * On the third move we step from -1 to 2.
     * Note:
     * target will be a non-zero integer in the range [-10^9, 10^9].
     *
     * @see <a href="https://leetcode.com/problems/reach-a-number/"/>
     */

    public static void main(String[] args) {
        System.out.println(reachNumber(7));
    }


    public static int reachNumber(int target) {
        //首先  全部往右走 和 其中一步往左走相差的距离是偶数

        //  距离  我第三步  应该是+3  但是变成-3     1+2+3 =6    1+2-3=0   其实是损失了2*3   就是如果有一步
        //  往左走  必定损失 2*i
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        //记录每步的距离  当等于 或者大于的时候停止
        while (sum < target) {
            step++;
            sum += step;
        }
        //如果 等于的时候可以直接返回  正好走到
        if (sum == target) return step;
        //如果相差是偶数 说明 其中一步往左走就可以到达
        if ((sum - target) % 2 == 0) return step;

        //奇数的话 就找到 满足是偶数的值 返回
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}

//  泽神的代码
//class Solution {
//    public int reachNumber(int target) {
//        target = Math.abs(target);
//        int res = (int) Math.sqrt(2 * target);
//        if ((res * res + res) / 2 == target) {
//            return res;
//        } else if (((res * res + res) / 2 + res + 1) == target) {
//            return res + 1;
//        } else {
//            while (((res * res + res) / 2 - target) < 0 || ((res * res + res) / 2 - target) % 2 != 0) {
//                res++;
//            }
//            return res;
//        }
//    }
//}
