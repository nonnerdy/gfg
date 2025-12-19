package org.biswajit.educative.practice.modules.datastructures.array;

import java.util.Arrays;

//LC : 189 - https://leetcode.com/problems/rotate-array/description/
public class RotateArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rightRotate(new int[]{1,2,3,4,5,6,7},12)));
    }

    public static int[] rightRotate(int [] nums ,int k){
        int len = nums.length;
        int actualRotate = k;
        int [] result = new int[len];
        if(k == len){
            return nums;
        }
        if(k > len){
           actualRotate = k % len;
        }

        int rotate = len - actualRotate;
        int l = 0;
        for ( int i = rotate,j = 0 ; i < len ; i++ ,j++){
            result[j] = nums[i];
            l++;
        }

        for(int j = l, i = 0 ; i < rotate ; i++, j++){
            result [ j] = nums [ i];
        }


        return result;
    }
}
