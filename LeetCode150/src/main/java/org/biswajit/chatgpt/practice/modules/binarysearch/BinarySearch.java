package org.biswajit.chatgpt.practice.modules.binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12},9));
    }

    public static int search(int[] nums, int target) {
        if(nums == null && nums.length == 0){
            return -1;
        }
        int left = 0 , right = nums.length - 1;
        while(right >= left){
            int midIndex = (left+right)/2;
            if(nums[midIndex] == target){
                return midIndex;
            }else if(nums[midIndex] < target){
                left = midIndex + 1;
            }else{
                right = midIndex - 1;
            }
        }
        return -1;
    }
}
