package org.biswajit.javaeight.ecommerceorderrevenuewithpartialrefunds;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderMain {
    public static void main(String[] args) {
        List<Order> orders = OrderDao.getOrders();

        //revnue = total pament - total refunds

      Map<String,Double> res =   orders.stream().collect(Collectors.groupingBy(Order::getCustomer,
                Collectors.summingDouble(order->{
                    double totalPayments = order.getPayments().stream().mapToDouble(Payment::getPayment).sum();
                    double totalRefunds = order.getRefunds().stream().mapToDouble(Refund::getRefund).sum();

                    return totalPayments - totalRefunds;
                }))).entrySet().stream()
                .filter(e->e.getValue() > 0)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));

        System.out.println(res);
    }
}
