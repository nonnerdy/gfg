package org.biswajit.javaeight.orderstatusvalidationstatemachine;

import java.util.List;

public class OrderDao {
    public static List<Order> getOrders(){
        return List.of(
                new Order("O1",List.of(OrderStatus.PLACED,OrderStatus.SHIPPED,OrderStatus.PACKED)),
                new Order("O2",List.of(OrderStatus.PLACED,OrderStatus.PACKED,OrderStatus.SHIPPED)));
    }
}
