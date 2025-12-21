package org.biswajit.javaeight.aggregateusingreduce;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CustomerPurchaseDetailsMain {
    public static void main(String[] args) {
        List<CustomerPurchaseDetails> customerPurchaseDetails = CustomerPurchaseDetailsDao.getPurchaseDetails();

     Map<String,Integer> a =    customerPurchaseDetails.stream().collect(
                Collectors.groupingBy(CustomerPurchaseDetails::getCustomer,
                        Collectors.reducing(0,CustomerPurchaseDetails::getAmount,Integer::sum))
        );

        System.out.println(a);
    }
}
