package org.biswajit.chatgpt.practice.modules;

import java.util.Arrays;

/*
Statement
Implement a function that rearranges elements in an array so that all negative elements appear to
the left and all positive elements (including zero) appear to the right.
 It’s important to note that maintaining the original sorted order of the input array is not required for this task.

Constraints:

1
≤
1≤
 arr.length
≤
1
0
3
≤10
3

1
0
−
5
≤
10
−5
 ≤
 arr.[i]
≤
1
0
5
≤10
5

[10,-1,20,4,5,-9,-6] -> [-1,-9,-6,10,20,4,5]
 */
public class RearrangePositiveAndNegativeValues {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangedArray(new int[]{-3, -10, -19, 21, -17})));
    }

    public static int[] rearrangedArray(int[] nums){
        int leftMostPosition = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] < 0) {
                if (i != leftMostPosition) {
                    int tmp = nums[i];
                    nums[i] = nums[leftMostPosition];
                    nums[leftMostPosition] = tmp;
                }
                leftMostPosition++;
            }
        }
        return nums;
    }
}
