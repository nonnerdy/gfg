package org.example.java.eight;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FrequencyOfWord {

    public static void main(String[] args) {
        String str = "apple banana apple orange banana apple";

        Map<String, Long> result = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);


    }
}
