package org.biswajit.javaeight.inventorylowstockmonitoring;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductMain {
    public static void main(String[] args) {
        List<Product> productList = ProductDao.getProductList();

        //Find categories where average stock is below 10.
        /*
        1. group by category
        2. for each category List of items
        3. find the average of the item count in each category
        4. check the average if it is below 10
        5. output will be Set of category.
         */


       Set<String> product =  productList.stream().collect(
                Collectors.groupingBy(Product::getProductCategory,
                Collectors.averagingInt(Product::getInventory)
        )).entrySet().stream()
                .filter(map -> map.getValue() < 10)
               .map(Map.Entry::getKey).collect(Collectors.toSet());

        System.out.println(product);
    }
}
