package org.biswajit.javaeight.userswitincreasingpurchasetrens;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PurchaseMain {
    public static void main(String[] args) {
        List<Purchase> purchaseList = PurchaseData.getPurchases();

      List<String> loyalCustomer = purchaseList.stream().collect(Collectors.groupingBy(Purchase::getUserId))
              .entrySet().stream().filter(
                      entry -> {
                          List<Purchase> purchases = entry.getValue().stream()
                                  .sorted(Comparator.comparing(Purchase::getDate)).toList();

                          if (purchases.size() < 2)
                              return false;

                          for (int i = 1; i < purchases.size(); i++) {
                              if (purchases.get(i).getAmount() < purchases.get(i - 1).getAmount())
                                  return false;
                          }
                          return true;
                      }
              ).map(Map.Entry::getKey).toList();


        System.out.println(loyalCustomer);
    }
}
