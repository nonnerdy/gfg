package org.biswajit.javaeight.inventoryshortagedetectionacrosswarehouses;

import java.util.List;
import java.util.Map;

public class InventoryDao {
    public static List<Inventory> getInventories(){
        return List.of(
                new Inventory("P1", "W1", 30),
                new Inventory("P1", "W2", 40),
                new Inventory("P2", "W1", 150),
                new Inventory("P2", "W2", 70)
        );
    }

    public static Map<String,Integer> getMinimumRequired(){
     return  Map.of(
                "P1", 100,
                "P2", 200
        );

    }
}
