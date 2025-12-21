package org.biswajit.javaeight.customerpurchaseconsistency;

import java.time.Month;
import java.time.YearMonth;
import java.util.List;

public class CustomerDao {
    public static List<Customer> getCustomerData(){
        return List.of(
                new Customer("C1", YearMonth.of(2024, Month.JANUARY)),
                new Customer("C1", YearMonth.of(2024, Month.FEBRUARY)),
                new Customer("C1", YearMonth.of(2024, Month.MARCH)),

                new Customer("C2", YearMonth.of(2024, Month.JANUARY)),
                new Customer("C2", YearMonth.of(2024, Month.MARCH)),

                new Customer("C3", YearMonth.of(2024, Month.FEBRUARY)),
                new Customer("C3", YearMonth.of(2024, Month.MARCH)),
                new Customer("C3", YearMonth.of(2024, Month.APRIL))
        );
    }
}
