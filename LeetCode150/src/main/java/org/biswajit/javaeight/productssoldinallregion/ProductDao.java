package org.biswajit.javaeight.productssoldinallregion;

import java.util.List;
/*
P1 NORTH
P1 SOUTH
P1 EAST
P2 NORTH
P2 SOUTH
 */
public class ProductDao {
    public static List<Product> getProductData(){
        return List.of(
                new Product("P1","NORTH"),
                new Product("P1","SOUTH"),
                new Product("P1","EAST"),
                new Product("P2","NORTH"),
                new Product("P2","SOUTH"),
                new Product("P2","EAST")
        );
    }
}
