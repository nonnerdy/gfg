package org.biswajit.chatgpt.practice.modules.twopointer;

import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,3,3,3},6)));
    }
    public static int[] twoSum(int[] numbers, int target) {
            int p1=0,p2=numbers.length-1;

            while(p1<p2){
                int tmp = numbers[p1] + numbers[p2];
                if(tmp == target){
                    return new int[]{p1+1,p2+1};
                }
                if(tmp>target)
                    p2--;
                else
                    p1++;
            }

        return new int[]{-1,-1};

    }
}
