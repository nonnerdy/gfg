package org.biswajit.educative.practice.modules.codinginterviewpatterns.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMaxSlidingWindow(new int[]{1,2,3,4,5,6,7,8,9,10},3)));
       }
    public static int[] findMaxSlidingWindow(int[] nums, int w) {

        // Replace this placeholder return statement with your code
        int length = nums.length;
        if(length < w)
            return new int[]{};

        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < length - w ; i++){
            int max = Integer.MIN_VALUE;
            int[] rangeCopy = Arrays.copyOfRange(nums,i,w+i);
            result.add(findMax(rangeCopy));
        }
        int[] arr = new int[result.size()];
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = result.get(i);
        }

        return arr;
    }
    public static int findMax(int[] nums){
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num > max)
                max = num;
        }
        return max;
    }
}
