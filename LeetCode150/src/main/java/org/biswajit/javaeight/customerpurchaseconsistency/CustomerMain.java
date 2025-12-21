package org.biswajit.javaeight.customerpurchaseconsistency;

import java.time.YearMonth;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CustomerMain {
    public static void main(String[] args) {
        String[] months = new String[]{"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
        /*
        1. get the list of months for a customer
        2. check count
        3. check the sequence
         */

        List<Customer> customerList = CustomerDao.getCustomerData();

       Set<String> m1 = customerList.stream().collect(
                Collectors.groupingBy(Customer::getName)).entrySet().stream().
               filter(
                       entry -> {
                           List<YearMonth> month =
                   entry.getValue().stream().map(Customer::getMonth).distinct().sorted().toList();

                            return hasNConsecutiveMonths(month,3);
                         }).map(Map.Entry::getKey).collect(Collectors.toSet());

        System.out.println(m1);
    }

    static boolean hasNConsecutiveMonths(List<YearMonth> months, int n) {
        if (months.size() < n) return false;

        for (int i = 0; i <= months.size() - n; i++) {
            YearMonth start = months.get(i);

            boolean consecutive = true;
            for (int j = 1; j < n; j++) {
                if (!start.plusMonths(j).equals(months.get(i + j))) {
                    consecutive = false;
                    break;
                }
            }

            if (consecutive) return true;
        }
        return false;
    }

}
