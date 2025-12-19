package org.biswajit.javaeight;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SimpleEight {
    public static void main(String[] args) {
        //Sum all positive numbers in nums.
        int[] arr = new int[]{2,4,-9,5,6,-9,12,-20};

        int sumOfNagetiveNums = Arrays.stream(arr).filter(i -> i < 0).sum();
        System.out.println("sumOfNagetiveNums "+sumOfNagetiveNums);

        //Find the max value in nums (empty-safe).
        OptionalInt maxNum = Arrays.stream(arr).max();
        System.out.println("Max Num "+maxNum.getAsInt());

        //. Count distinct values in nums.
        //Arrays.stream(arr).distinct();
        //
    }
}
