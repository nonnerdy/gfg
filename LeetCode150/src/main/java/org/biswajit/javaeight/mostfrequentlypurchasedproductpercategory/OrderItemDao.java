package org.biswajit.javaeight.mostfrequentlypurchasedproductpercategory;

import org.biswajit.javaeight.mostfrequentlypurchasedproductpercategory.OrderItem;

import java.util.List;

public class OrderItemDao {

    /*
    Electronics: Phone, Phone, TV
Grocery: Rice, Rice, Wheat
     */

    public static List<OrderItem> listOrderItems(){
        return List.of(new OrderItem("Phone","Electronics"),
                new OrderItem("Phone","Electronics"),
                new OrderItem("Tv","Electronics"),
                new OrderItem("Rice","Grocery"),
                new OrderItem("Rice","Grocery"),
                new OrderItem("Wheat","Grocery"));
    }
}
