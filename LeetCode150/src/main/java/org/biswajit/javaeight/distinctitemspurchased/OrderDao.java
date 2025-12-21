package org.biswajit.javaeight.distinctitemspurchased;

import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    public static List<Order> getOrderList(){
        return List.of(
                new Order("Order1",List.of(new Items("Phone"),new Items("Charger"))),
                new Order("Order2",List.of(new Items("Charger"),new Items("Earphones"))),
                new Order("Order1",List.of(new Items("Cable"),new Items("Charger")))
        );
    }
}
