package org.biswajit.chatgpt.practice.modules;

/*
https://leetcode.com/problems/contains-duplicate/
 */

import java.util.HashMap;
import java.util.Map;
//LC 217
public class ContainsDuplicate {
    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));

    }
    public static boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> countDuplicate = new HashMap<>();
        for(int i : nums){
            if(countDuplicate.containsKey(i) && countDuplicate.get(i) >= 1)
            return true;
            countDuplicate.put(i,countDuplicate.getOrDefault(i,0)+1);
        }
        return false;
    }
}
