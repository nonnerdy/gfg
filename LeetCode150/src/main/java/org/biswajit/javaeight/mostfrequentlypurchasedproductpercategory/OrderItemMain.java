package org.biswajit.javaeight.mostfrequentlypurchasedproductpercategory;

import org.biswajit.javaeight.mostfrequentlypurchasedproductpercategory.OrderItem;
import org.biswajit.javaeight.mostfrequentlypurchasedproductpercategory.OrderItemDao;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderItemMain {
    public static void main(String[] args) {
        List<OrderItem> orderItems = OrderItemDao.listOrderItems();
        System.out.println(orderItems);

        /*
        Map<ProductCategory,List<Map<ProductId,Integer>>>
         */

        Map<String, String> mostFrequentProductByCategory =
                orderItems.stream().collect(Collectors.groupingBy(
                OrderItem::getProductCategory,
                Collectors.collectingAndThen(
                        Collectors.groupingBy(
                                OrderItem::getProductId,
                                Collectors.counting()
                        ),
                        productCountMap->productCountMap.entrySet()
                                .stream()
                                .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                .orElse(null)
                )));

        System.out.println(mostFrequentProductByCategory);
    }
}
