package org.biswajit.chatgpt.practice.modules.backtracking;

import java.util.ArrayList;
import java.util.List;

//76
public class Subsets {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};

        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),result);
        return result;
    }

    private static void backtrack(int i, int[] nums, ArrayList<Integer> current, List<List<Integer>> result) {
        //base case
        if(nums.length == i){
            result.add(new ArrayList<>(current));
            return;
        }

        //1. include current element -> take path
        current.add(nums[i]);
        backtrack(i+1,nums,current,result);
        //2. exclude current element -> reject path
        current.remove(current.size() - 1);
        backtrack(i+1,nums,current,result);
    }
}
