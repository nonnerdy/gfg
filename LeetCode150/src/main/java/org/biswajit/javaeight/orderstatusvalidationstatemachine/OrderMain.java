package org.biswajit.javaeight.orderstatusvalidationstatemachine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderMain {
    public static void main(String[] args) {
       // OrderStatus[] statuses = {,OrderStatus.PACKED,OrderStatus.SHIPPED,OrderStatus.DELIVERED};
        Map<OrderStatus,Integer> stat = new HashMap<>();
        stat.put(OrderStatus.PLACED,1);
        stat.put(OrderStatus.PACKED,2);
        stat.put(OrderStatus.SHIPPED,3);
        stat.put(OrderStatus.DELIVERED,4);
        //0,1,2,3

        List<Order> orders = OrderDao.getOrders();

       List<String> o = orders.stream().collect(Collectors.groupingBy(Order::getOrderId))
                .entrySet().stream()
                .filter(el->{
                    int point = 0;
                    for(OrderStatus status : el.getValue().get(0).getOrderStatus()){
                        if(point == 0){
                            point = stat.get(status);
                            continue;
                        }
                        if(stat.get(status) >= point) {
                            point = stat.get(status);
                        }else{
                            return true;
                        }
                    }
                    return false;
                }).map(Map.Entry::getKey).toList();

        System.out.println(o);

    }
}
