package org.biswajit.javaeight.customerpurchaseconsistency;

import java.util.List;

public class CustomerDao {
    public static List<Customer> getCustomerData(){
        return List.of(
                new Customer("C1",Months.JAN),
                new Customer("C2",Months.JAN),
                new Customer("C3",Months.APR),
                new Customer("C1",Months.FEB),
                new Customer("C1",Months.MAR),
                new Customer("C1",Months.APR),
                new Customer("C2",Months.FEB),
                new Customer("C2",Months.MAR),
                new Customer("C3",Months.MAY),
                new Customer("C4",Months.JAN)
        );
    }
}
