package org.biswajit.javaeight.chatgptgenerated.topncustomerbyspend;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerMain {
    public static void main(String[] args) {
        /*
        Input: (1,200), (2,500), (1,300), (3,700), (2,100)

        Output: (3,700), (2,600), (1,500)
         */
        List<Customer> customerList = List.of(
                new Customer(1, 200),
                new Customer(2, 500),
                new Customer(1, 300),
                new Customer(3, 700),
                new Customer(2, 100),
                new Customer(4, 400),
                new Customer(5,1000));

        Map<Integer,Integer> c = customerList.stream().collect(Collectors.groupingBy(
                Customer::getId,
                Collectors.summingInt(Customer::getSpending)
        ))
                .entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(3).collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                       (e1,e2)->e2,LinkedHashMap::new));


        System.out.println(c);


    }
}
