package org.biswajit.javaeight.orderstatusfunnelanalysis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderMain {
    public static void main(String[] args) {
        List<Order> orderList = OrderDao.getOrders();
        List<OrderStatus> allStatus = List.of(OrderStatus.CREATED,OrderStatus.PAID,OrderStatus.SHIPPED,OrderStatus.DELIVERED);



        Map<OrderStatus,Long> orderStatusIntegerMap =orderList.stream().collect(
                Collectors.groupingBy(Order::getOrder,
                        Collectors.mapping(
                                Order::getOrderId,Collectors.collectingAndThen(
                                        Collectors.toSet(),set -> (long) set.size()
                                )
                        ))
        );

        for(OrderStatus orderStatus : allStatus){
            if(!orderStatusIntegerMap.containsKey(orderStatus))
                orderStatusIntegerMap.put(orderStatus,0L);
        }

        System.out.println(orderStatusIntegerMap);
    }
}
