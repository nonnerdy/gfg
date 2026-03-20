package org.biswajit.javaeight.javaeightinterviewcondingandquestions;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JavaEightTop20ChatGPT {
    public static void main(String[] args) throws InterruptedException {
        /*
        1. Top N Frequent Elements
            Given a list of integers, return the top 3 most frequent numbers.
            Example
             [1,2,3,2,4,1,1,5,3,3,3]
         */
        int[] freqElement = new int[]{1,2,3,2,4,1,1,5,3,3,3};

        List<Integer> freElem = Arrays.stream(freqElement).boxed().collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        )).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
        map(Map.Entry::getKey).limit(3).toList();

        System.out.println("Top 3 most frequent element "+freElem);

        /*
        2. Longest String in a List
            Find the longest string in a list.

            Example
            ["java","springboot","microservices","docker"]

            Concepts:
            max
         */

        List<String> longestStr = List.of("java","springboot","microservices","docker");

        String longest = longestStr.stream().sorted(Comparator.comparingInt(String::length).reversed()).findFirst().get();
        System.out.println("longest substring from the list : "+longestStr+ " is "+longest);

        /*
        3. Group Words by Length
           Group words based on their length.
         */

        List<String> groupWords = List.of("cat","dog","elephant","tiger");

        Map<Integer, List<String>> groupedByLength = groupWords.stream().collect(Collectors.groupingBy(
                String::length));
        System.out.println("group words by length : "+groupedByLength);

        /*
        Find Duplicate Elements
        Find all duplicate numbers in a list.
        Example
        [1,3,4,5,3,2,4,7,8,1]
         */

        int[] findDup = new int[]{1,3,4,5,3,2,4,7,8,1};
        List<Integer> dupliactes = Arrays.stream(findDup).boxed().collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        )).entrySet().stream().filter(el->el.getValue()>1).map(Map.Entry::getKey).toList();

        System.out.println("Duplicate numbers from an array :"+dupliactes);

        A a = new A();
        Thread t1 = new Thread(()->{
           for(int i = 0 ; i < 1000 ; i++){
               a.incrementCounter();
           }
        });

        Thread t2 = new Thread(()->{
            for(int i = 0 ; i < 1000 ; i++){
                a.incrementCounter();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(a.counter);




        //Write a program to find even numbers from a list and multiply them by 2 using streams
        List<Integer> evMul = List.of(2,3,4,5,6,7,8);

        List<Integer> ev = evMul.stream().filter(e->e%2==0).map(el->el*2).toList();
        System.out.println(ev);

        //Write a program to find the sum of the entire array using Java 8 streams.
        int[] arp = new int[]{1,2,3,4,5,6,7,8,9};

        int totalsum  = Arrays.stream(arp).boxed().max(Comparator.comparingInt(d->d)).get();
        System.out.println(totalsum);

        char[] ch = new char[]{'a','b',2,3,'t'};


    }

}

class A {
    int counter = 0;
    //AtomicInteger counter = new AtomicInteger();
    public synchronized void incrementCounter(){
       // counter.getAndIncrement();
        counter++;
    }

}
