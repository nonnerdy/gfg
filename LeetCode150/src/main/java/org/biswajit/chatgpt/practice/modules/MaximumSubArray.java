package org.biswajit.chatgpt.practice.modules;

public class MaximumSubArray {
    public static void main(String[] args) {
        System.out.println( maxSubArray(new int [] {1, 2, 2, 3, 3, 1, 4}));
    }

    public static int maxSubArray(int[] A) {

        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
