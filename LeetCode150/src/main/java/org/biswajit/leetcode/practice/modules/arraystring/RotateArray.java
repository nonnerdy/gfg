package org.biswajit.leetcode.practice.modules.arraystring;


import java.util.Arrays;

/*
https://leetcode.com/problems/rotate-array/description/?envType=study-plan-v2&envId=top-interview-150

    Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;

        RotateArray rotateArray = new RotateArray();
        int[] rotatedArray = rotateArray.rotateArray(arr,k);
//        for(int i : rotatedArray){
//            System.out.print(i+",");
//        }
        System.out.println("Rotated array "+Arrays.toString(rotatedArray));


    }

    public int[] rotateArray(int[] arr, int k){

        //1. if k is == 0 then return the array as it is
            //2. decrement k by 1 in each iteration
            /*
            1,2,3,4,5,6,7
            swap first and last number.
             k = 13
                   1,2,3,4,5,6,7
            1  ->  7,1,2,3,4,5,6
            2  ->  6,7,1,2,3,4,5
            3  ->  5,6,7,1,2,3,4
            4  ->  4,5,6,7,1,2,3
            5  ->  3,4,5,6,7,1,2
            6  ->  2,3,4,5,6,7,1
            7  ->  1,2,3,4,5,6,7
            8  ->  7,1,2,3,4,5,6
            9  ->  6,7,1,2,3,4,5
            10 ->  5,6,7,1,2,3,4
            11 ->  4,5,6,7,1,2,3
            12 ->  3,4,5,6,7,1,2
            13 ->  2,3,4,5,6,7,1
            check if K is > arr.length
            then take the mod value
             */
        int n = arr.length;
        k = k % n;

        reverse(arr, 0, n - 1);      // reverse all
        reverse(arr, 0, k - 1);      // reverse first k
        reverse(arr, k, n - 1);

        return arr;

    }

    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }

}
