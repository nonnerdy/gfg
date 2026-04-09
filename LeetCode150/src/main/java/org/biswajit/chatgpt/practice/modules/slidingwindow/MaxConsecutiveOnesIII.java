package org.biswajit.chatgpt.practice.modules.slidingwindow;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        System.out.println(findLongestOne(new int[]{0, 0, 0, 1}, 4));
    }

    public static int findLongestOne(int[] nums, int k) {
        int left = 0, right = 0, counter = 0, length = 0;

        while (right < nums.length) {

            if (nums[right] == 0) {
                counter++;
            }
            // shrink if invalid
            while (counter > k) {
                if (nums[left] == 0) {
                    counter--;
                }
                left++;
            }
            // update length
            length = Math.max(length, (right - left + 1));

            right++;
        }

        return length;
    }
}
