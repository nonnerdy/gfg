package org.biswajit.javaeight.aggregateusingreduce;

import java.util.List;

public class CustomerPurchaseDetailsDao {
    public static List<CustomerPurchaseDetails> getPurchaseDetails(){
        return List.of(
                new CustomerPurchaseDetails("C1",200),
                new CustomerPurchaseDetails("C1",300),
                new CustomerPurchaseDetails("C2",500),
                new CustomerPurchaseDetails("C3",100),
                new CustomerPurchaseDetails("C2",100)
        );
    }
}
