package org.biswajit.javaeight;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestPrograms {

    static class Employee {
        private int id;
        private String name;
        private String department;
        private double salary;

        public Employee(int id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public String getName() { return name; }
        public String getDepartment() { return department; }
        public double getSalary() {return salary;}
        // Getters for id and salary as needed
        @Override
        public String toString() {
            return "Employee{" +
                    "EmployeeName='" + name + '\'' +
                    ", department='" + department + '\'' +
                    ", salary='" + salary + '\'' +
                    '}' ;
        }

    }
    public static void main(String[] args) {
        /*
        Group Anagrams (without sorting string explicitly)

        Group words that are anagrams using streams only.
         */
        String[] arrStr = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(

                Arrays.stream(arrStr).collect(Collectors.groupingBy(
                        e->{
                            char[] arr = e.toCharArray();
                            Arrays.sort(arr);
                            return new String(arr);
                        }
                ))
        );

        //Top K Frequent Elements
        //nums = [1,1,1,2,2,3], k = 2
        // two most frequent element
        //sort the array then grop it and get first two key
        int[] a = new int[]{1,1,1,2,2,3};
        System.out.println(Arrays.stream(a).boxed().sorted(Comparator.comparing(Integer::reverse)).collect(
                Collectors.groupingBy(Function.identity(),Collectors.counting())
        ).keySet().stream().limit(2).toList());

        //Longest String per Starting Character
        /*
["apple","ape","bat","ball","cat","car"]

        {
 'a': "apple",
 'b': "ball",
 'c': "car"
}
         */

        String[] c = new String[]{"apple","ape","bat","ball","cat","car"};
        System.out.println(Arrays.stream(c).collect(Collectors.groupingBy(el->el.charAt(0),
                Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(String::length)), Optional::get))));



        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(2,3,4),
                Arrays.asList(4,5)
        );

        System.out.println(input.stream().flatMap(List::stream).distinct().toList());

        /*

        First Non-Repeating Character

Input:

"swiss"

Output:

'w'
         */

        String d = "swiss";


        Character result = d.chars()
                .mapToObj(ca -> (char) ca)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,   // preserves order
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);


        List<Integer> numbers = Arrays.asList(10, 20, 35, 50, 50, 45);

        int secondHighest = numbers.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        System.out.println(secondHighest);

        String inputa = "accenture";
        Map<Character,Integer> fmap = new HashMap<>();

        for(char b : inputa.toCharArray()){
            fmap.merge(b,1,Integer::sum);
        }
        System.out.println(fmap);

        System.out.println(inputa.chars().mapToObj(ca->(char) ca).collect(Collectors.groupingBy(
            Function.identity(),Collectors.counting()
    )));


        List<Employee> employees = Arrays.asList(
                new Employee(101, "John Doe", "IT", 75000),
                new Employee(102, "Alice Smith", "HR", 60000),
                new Employee(103, "Robert Brown", "IT", 82000),
                new Employee(104, "Emily Davis", "Finance", 70000),
                new Employee(105, "Michael Wilson", "IT", 55000)
        );

        //maximum salary per department
        System.out.println(employees.stream().collect(Collectors.groupingBy(
                Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))
        )));


        System.out.println(employees.stream().
                filter(emp->emp.getDepartment().equals("IT")).
                map(emp->emp.getName().toUpperCase()).toList());

        System.out.println(

                employees.stream().collect(Collectors.groupingBy(
                        Employee::getDepartment,Collectors.toList()
                ))

        );

        List<String> rdata = List.of("apple", "bat", "cat", "banana", "dog");

        System.out.println( rdata.stream().collect(Collectors.groupingBy(
               String::length
       )));

        int[] sq = new int[]{1, 2, 3, 4, 5};

        System.out.println(Arrays.stream(sq).map(in->in*in).reduce(0, Integer::sum));

        List<String> strApp = List.of("Java", "Python", "C++");

        System.out.println(strApp.stream().collect(Collectors.joining(",","[","]")));



    }
}
