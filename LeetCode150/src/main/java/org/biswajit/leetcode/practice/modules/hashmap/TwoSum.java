package org.biswajit.leetcode.practice.modules.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//LC - 1
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numMap = new HashMap<>();
        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            int complements = target - nums[i];
            if(numMap.containsKey(complements)){
                return new int[] {numMap.get(complements),i};
            }
            numMap.put(nums[i],i);
        }
        return new int[]{};

    }
}
