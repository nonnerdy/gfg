package org.biswajit.chatgpt.practice.modules;

import java.util.Arrays;

/*
Statement :
We're given a sorted array, nums, containing positive integers only. We have to rearrange the array so that when returned, the
0th index of the array will have the largest number, the 1st index will have the smallest number, the 2nd index will have the
second largest number, the 3rd index will have the second smallest number, and so on.
In the end, we’ll have the largest remaining numbers in descending order and the smallest in ascending
order at even and odd positions, respectively.


[1,2,3,4,5,6,7,8] -> [8,1,7,2,6,3,5,4]


 */
public class RearrangeSortedArrayInMaxMinForm {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotatedArray(new int[]{1,2,3,4,5,6,7,8})));
    }

    public static int[] rotatedArray(int [] nums){
        // we will implement using two pointer.
        // first one will be in the 0th pos
        //2nd one will be on the last position
        // after each iteration first++ and Second--
        /*
        [1,2,3,4,5,6,7,8] -> [8,1,7,2,6,3,5,4]
        [8,1]
        fist = 0
        last = 8
        arr[first] = 1
        arr[last] = 8
        while (first < last)


         */


        int n = nums.length;
        if (n == 0) return nums;

        // Initialize pointers to the start and end of the array
        int maxIdx = n - 1;
        int minIdx = 0;
        // Initialize a variable larger than any element in the array to use for encoding
        int maxElem = nums[n - 1] + 1;

        // Encoding phase
        for (int i = 0; i < n; ++i) {
            if (i % 2 == 0) {  // Encoding at even indexes
                nums[i] += (nums[maxIdx] % maxElem) * maxElem;
                maxIdx--;
            } else {  // Encoding at odd indexes
                nums[i] += (nums[minIdx] % maxElem) * maxElem;
                minIdx++;
            }
        }

        // Decoding phase
        for (int i = 0; i < n; ++i) {
            nums[i] = nums[i] / maxElem;
        }

        return nums;

    }

}
