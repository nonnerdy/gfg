package org.biswajit.javaeight.ecommerceorderrevenuewithpartialrefunds;

import java.util.List;

public class OrderDao {
    public static List<Order> getOrders(){
       return List.of(
                new Order("O1", "C1",
                        List.of(new Payment(500), new Payment(300)),
                        List.of(new Refund(200))
                ),
                new Order("O2", "C1",
                        List.of(new Payment(400)),
                        List.of()
                ),
                new Order("O3", "C2",
                        List.of(new Payment(600)),
                        List.of(new Refund(700))
                ));
    }
}
