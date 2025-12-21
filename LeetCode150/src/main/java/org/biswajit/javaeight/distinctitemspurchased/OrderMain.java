package org.biswajit.javaeight.distinctitemspurchased;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderMain {
    public static void main(String[] args) {
        List<Order> orders = OrderDao.getOrderList();
        Set<Items> uniqueItems = new HashSet<>();

        /*
        1. get orderlist
        2. get distinct

        Order1=[Order{orderId='Order1', items=[Items{itemName='Phone'}, Items{itemName='Charger'}]},
                Order{orderId='Order1', items=[Items{itemName='Cable'}, Items{itemName='Charger'}]}]
         */

        List<String> distinctItemNames = orders.stream().flatMap(order -> order.getItems().stream())
                      .map(Items::getItemName)
                              .distinct()
                                      .collect(Collectors.toList());

        System.out.println(distinctItemNames);
    }
}
