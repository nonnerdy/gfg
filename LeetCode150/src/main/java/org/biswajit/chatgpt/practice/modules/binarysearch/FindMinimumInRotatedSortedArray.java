package org.biswajit.chatgpt.practice.modules.binarysearch;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findMin(new int[]{4,5,6,7,0,1,2}));
    }
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while(right > left){
            int mid = left + (right - left)/2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }

        }
        return nums[left];
    }
}
