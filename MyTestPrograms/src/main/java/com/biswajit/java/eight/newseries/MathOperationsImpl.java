package com.biswajit.java.eight.newseries;

import java.util.function.Function;

public class MathOperationsImpl  {
    public static void main(String[] args) {
       MathOperation operation = Integer::sum;
       MathOperation operation1 = (a,b) -> a*b;

        System.out.println("Sum "+operation.operate(10,22));
        System.out.println("Multiplication "+operation1.operate(10,22));

        Function<String, Integer> stringIntegerFunction = String::length;
        String sample = "find the length of this string using method reference";

        System.out.println(stringIntegerFunction.apply(sample));

    }


}
