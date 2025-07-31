package com.biswajit.java.eight;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListEmployee {

    public static void main(String args[]) {
        LinkedList<Integer> hh = new LinkedList<>();
       // Collections.sea
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Alex", 23, "USA"));
        list.add(new Employee("Dave", 34, "India"));
        list.add(new Employee("Carl", 21, "USA"));
        list.add(new Employee("Joe", 56, "Russia"));
        list.add(new Employee("Amit", 64, "China"));
        list.add(new Employee("Ryan", 19, "Brazil"));


        List<Employee> collect = list.stream().filter(el -> el.age > 50).collect(Collectors.toList());
        System.out.println(collect);
        List<Employee> collect1 = list.stream().filter(el -> el.country != "USA").collect(Collectors.toList());
        System.out.println(collect1);
      //  Collections.sort(list,(e1,e2)->e1.country.compareTo(e2.country));
        List<Employee> collect2 = list.stream().sorted(Comparator.comparing(e -> e.country)).collect(Collectors.toList());
        System.out.println(collect2);
    }

}

