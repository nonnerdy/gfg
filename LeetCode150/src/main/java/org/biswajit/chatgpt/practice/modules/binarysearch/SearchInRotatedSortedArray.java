package org.biswajit.chatgpt.practice.modules.binarysearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{5,1,3},0));
    }
    public static int search(int[] nums, int target) {
        int left = 0 , right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target)
                return mid;

            if(nums[left] <= nums[mid]){
                if(nums[left] <= target && nums[mid]>=target){
                    right = mid - 1;
                }else{
                    left = mid+1;
                }
            }else{
                if(nums[right] >= target && nums[mid] <= target){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
