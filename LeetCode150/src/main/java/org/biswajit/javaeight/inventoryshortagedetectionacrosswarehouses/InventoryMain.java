package org.biswajit.javaeight.inventoryshortagedetectionacrosswarehouses;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InventoryMain {
    public static void main(String[] args) {
        List<Inventory> inventories = InventoryDao.getInventories();
        Map<String,Integer> minumumrequired = InventoryDao.getMinimumRequired();

//       Map<String,Map<String,List<Inventory>>> d = inventories.stream().collect(
//                Collectors.groupingBy(Inventory::getProduct,
//                        Collectors.groupingBy(
//                                Inventory::getWarehouses,
//                                Collectors.mapping(el->{
//                                    boolean b = minumumrequired.get(el.getProduct()) > el.getQuantity();
//                                })
//                        ))
//        );

     //   System.out.println(d);
    }
}
