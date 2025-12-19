package org.biswajit.javaeight.inventorylowstockmonitoring;

import java.security.Permission;
import java.util.List;

public class ProductDao {

    public static List<Product> getProductList(){
        return List.of(
          new Product("Galaxy S20FE","Mobile",5),
                new Product("IPhone","Mobile",3),
                new Product("Sony Bravia","TV",2),
                new Product("Samsumg wall","TV",9),
                new Product("TCL 896K","TV",21),
                new Product("Moto G","Mobile",3)
        );
    }
}
