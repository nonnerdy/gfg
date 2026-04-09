package org.biswajit.chatgpt.practice.modules.twopointer;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }
    public static void moveZeroes(int[] nums) {
        int count=0;
        int[] resArray = new int[nums.length];

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] !=0){
                resArray[count] = nums[i];
                count++;
            }
        }
//        for(int i = zeroCount+1 ; i < nums.length ; i++){
//            resArray[i] = 0;
//        }
        System.out.println(Arrays.toString(resArray));
    }
}
