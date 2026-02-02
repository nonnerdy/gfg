package org.biswajit.leetcode.practice.modules.slidingwindow;


import java.util.HashSet;
import java.util.Set;

//L219 : https://leetcode.com/problems/contains-duplicate-ii/?envType=problem-list-v2&envId=sliding-window&
public class ContainsDuplicateTwo {
    public static void main(String[] args) {

        System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
      //  System.out.println(containsNearbyDuplicate(new int[]{1,2,3,1},3));

    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (window.contains(nums[i])) {
                return true;
            }
            window.add(nums[i]);

            if (window.size() > k) {
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}
