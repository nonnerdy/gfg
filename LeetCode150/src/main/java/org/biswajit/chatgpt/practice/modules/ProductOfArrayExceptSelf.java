package org.biswajit.chatgpt.practice.modules;

import java.util.Arrays;

//LC 238
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{12,1,23,45,67,8,9,43,79,14,52,7,92})));
    }
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        res[0] = 1;
        int left = 1;
        for(int i = 0 ; i < n  ; i++){
            if(i > 0)
                left = left * nums[i - 1];
            res[i] = left;
        }

        int right = 1;
        for(int i = n - 1; i >=0 ; i--){
            if(i < n - 1)
                right = right * nums[i + 1];
            res[i] *= right;
        }
        return res;
    }
}
