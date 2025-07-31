package com.biswajit.java.eight;

import java.util.*;
import java.util.stream.Collectors;

public class JavaStreams {
    public static void main(String[] args) {

        //find average
        int[] arr = new int[]{23,12,4,27,66};
        double avg = Arrays.stream(arr).average().getAsDouble();
        System.out.println(avg);

        //String upper to lower case
        // List {"abc","ear","Alphabet"}
        List<String> caseLetter = List.of(new String[]{"abc", "ear", "Alphabet"});
        List<String> res = caseLetter.stream().map(String::toUpperCase).toList();
        System.out.println("Upper case "+res.toString());

        //Sum all even and odd numbers in a alist
        // {12,23,34,45,56,76} =>{44.5,34}

        List<Integer> evenOdd = List.of(new Integer[]{12,23,34,45,56,76});

        Map<String,Integer> employees = new HashMap<>();
        employees.put("Biswajit",12000);
        employees.put("Sudipta",14000);
        employees.put("Anuj",16000);
        employees.put("Sayantan",10000);
        employees.put("Subha",12000);
        employees.put("Tometo",14000);
        employees.put("Snehendu",12000);

        getNthHighestSalary(employees);


    }

    public static void getNthHighestSalary(Map<String, Integer> employees){
        //get the nth highest salary people
        Map.Entry<Integer, List<String>> integerListEntry = employees.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())))
                .entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByKey()))
                .toList()
                .get(2);

        System.out.println(integerListEntry);



    }
}
