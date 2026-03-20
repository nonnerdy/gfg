package org.biswajit.javaeight.chatgptgenerated.tradingsystem;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TradingMain {
    public static void main(String[] args) {
        /*
        (A, INFY, 10, 1000, BUY)
(A, INFY, 5, 1100, SELL)
(A, TCS, 20, 2000, BUY)
(B, INFY, 15, 1050, BUY)
(B, INFY, 5, 1000, SELL)
         */
        List<Trading> tradingList = List.of(
                new Trading("A", "INFY", 10, 1000, TradeType.BUY),
                new Trading("A", "INFY", 5, 1100, TradeType.SELL),
                new Trading("A", "TCS", 20, 2000, TradeType.BUY),
                new Trading("B", "INFY", 15, 1050, TradeType.BUY),
                new Trading("B", "INFY", 5, 1000, TradeType.SELL));

        /*
        1. group by client id
        output -> Map<String,List<Trading>>
        2. group the List<Trading> by stock.
        3. deduct SELL from BUY

        o/p-> {
          A -> { INFY: 5, TCS: 20 },
          B -> { INFY: 10 }
        }

            Map<String,Map<String,Integer>>
         */

        /*


         INFY=[
         Trading(clientId=A, stock=INFY, quantity=10, price=1000, type=BUY),
         Trading(clientId=A, stock=INFY, quantity=5, price=1100, type=SELL)]

         */


        System.out.println(



                tradingList.stream().collect(Collectors.groupingBy(
                Trading::getClientId,Collectors.collectingAndThen(
                        Collectors.groupingBy(Trading::getStock,
                                Collectors.summingInt(trade->trade.getType() == TradeType.BUY?trade.getQuantity():-trade.getQuantity())),
                                stockMap->stockMap.entrySet().stream()
                                        .filter(e->e.getValue()!=0)
                                        .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue))
                        ))));








    }
}
