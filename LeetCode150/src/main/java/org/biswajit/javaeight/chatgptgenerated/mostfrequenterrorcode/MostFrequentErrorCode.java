package org.biswajit.javaeight.chatgptgenerated.mostfrequenterrorcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MostFrequentErrorCode {
    public static void main(String[] args) {
        int[] errorCodes = new int[]{500,404,500,403,500,404};

       List<Integer> highestFreqErrorCode =  Arrays.stream(errorCodes).boxed().collect(
                Collectors.groupingBy(
                        Function.identity(),Collectors.counting()
                )).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(1).map(Map.Entry::getKey).toList();

        System.out.println(highestFreqErrorCode);
    }
}
