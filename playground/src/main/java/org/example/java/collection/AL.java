package org.example.java.collection;

import java.util.*;
import java.util.stream.Collectors;

public class AL {
    public static void main(String[] args) {

        //get size of the array
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(10);
        System.out.println(list);

        Collections.sort(list);

        System.out.println(list);

        System.out.println("Reverse order ");
        list.sort(Collections.reverseOrder());
        System.out.println(list);

        list
                .stream()
                .sorted().forEach(System.out::print);
    }
}
