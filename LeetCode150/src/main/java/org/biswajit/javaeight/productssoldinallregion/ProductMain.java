package org.biswajit.javaeight.productssoldinallregion;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductMain {
    public static void main(String[] args) {
      List<String> regions = List.of("NORTH","SOUTH","EAST");

        List<Product> products = ProductDao.getProductData();

     List<String> s =    products.stream().collect(Collectors.groupingBy(Product::getProductId))
                .entrySet().stream().filter(
                        product -> {
                        Set<String> regionList = product.getValue().stream().map(Product::getRegion).collect(Collectors.toSet());

                        if(regionList.size() < 3)
                            return false;

                        for(String rg : regions){
                            if(!regionList.contains(rg))
                                return false;
                        }
                        return true;

                        }
                ).map(Map.Entry::getKey).toList();


        System.out.println(s);

    }
}
