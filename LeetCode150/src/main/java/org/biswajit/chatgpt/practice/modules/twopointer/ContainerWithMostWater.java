package org.biswajit.chatgpt.practice.modules.twopointer;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    public static int maxArea(int[] height) {
        int left =0,right = height.length - 1,maxArea = 0;
        while(right > left){
            maxArea = Math.max(maxArea,(right - left )*Math.min(height[right],height[left]));
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}
