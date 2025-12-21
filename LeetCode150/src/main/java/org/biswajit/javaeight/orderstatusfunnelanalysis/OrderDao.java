package org.biswajit.javaeight.orderstatusfunnelanalysis;

import java.util.List;

public class OrderDao {
    public static List<Order> getOrders(){
        return List.of(
                new Order("O1",OrderStatus.CREATED),
                new Order("O1",OrderStatus.PAID),
                new Order("O2",OrderStatus.CREATED),
                new Order("O2",OrderStatus.PAID),
                new Order("O3",OrderStatus.CREATED)
        );
    }
}
