package org.biswajit.chatgpt.practice.modules.slidingwindow;

public class SubArrayProductLessThanK {
    public static void main(String[] args) {
        System.out.println(findSubArrayProduct(new int[]{10,5,2,6},100));
    }
    public static int findSubArrayProduct(int[] nums, int k){
        int left = 0 , right = 0, product = 1, count = 0, window = 0;
        for(right = 0 ; right < nums.length ; right++){

            if(nums[right] < k)
                count++;
            window = (right - left);
            int l = left;
            while(l<right){
                //window = (right - left + 1);
                product = product * nums[l++];
                window--;
            }
            if(product < k )
                count++;
            else{
                    left--;

                }
            }
        return count;
        }
    }

