package com.leetcode.daliy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author TSN
 * @date 2020/3/26
 * @Description
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] a = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(Arrays.toString(threeSum(a).toArray()));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                return result;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left+1]) {
                        if (nums[left] == nums[left + 1]) {
                            left++;
                        }
                    }
                    while (left < right && nums[right] == nums[right-1]) {
                        if (nums[right] == nums[right - 1]) {
                            right--;
                        }
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        return result;

    }
}
