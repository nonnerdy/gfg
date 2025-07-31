package com.biswajit.leetcode.top150interviewquestions;

public class JumpGame {
    public static void main(String[] args) {
//        int[] arr = {2,3,1,1,4};
//        System.out.println(canMakeJump(arr));
        int [] arr = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr));
    }
    public static boolean canMakeJump(int[] nums){
        int length = nums.length;
//        for(int i = 0 ; i < length ; ){
//            if(nums[i] == 0 && i != length - 1){
//                return false;
//            }
//            else if(nums[i] > length - 1){
//                return false;
//            }
////            else if(nums[i] > length - 1 - i){
////                return false;
////            }
//            i = nums[i];
//        }
//        return true;
        int i = 0;
        while( i < length - 1){
            if(nums[i] == 0 && i != length - 1){
                return false;
            }
            else if(nums[i] > length - 1){
                return false;
            }
            else if(nums[i] > length - 1 - i){
                return false;
            }

        }
        return false;
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int initial = 0;
        int terminal = 1;
        int count = 1;
        while(terminal < nums.length){
            if(nums[initial] == nums[terminal]){
                terminal++;
                continue;
            }else{
                count++;
                initial = terminal;
                terminal++;
            }
        }
        return count;

    }
}
