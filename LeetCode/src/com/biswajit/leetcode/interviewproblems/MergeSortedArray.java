package com.biswajit.leetcode.interviewproblems;

import java.util.Arrays;

/*
https://leetcode.com/problems/merge-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
        mergeSortedArray.merge(new int[]{1, 2, 3, 0, 0, 0},3,new int[]{2,5,6},3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sampleArray = new int[m+n];
        for(int i = 0 ; i < m ; i++){
            sampleArray[i] = nums1[i];
        }
        for(int i = 0 ; i < n ; i++){
            sampleArray[m+i] = nums2[i];
        }
        Arrays.sort(sampleArray);
        System.out.println(Arrays.toString(sampleArray));
    }
}
