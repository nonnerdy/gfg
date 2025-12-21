package org.biswajit.javaeight.paymentfailuredetection;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class PaymentMain {
    public static void main(String[] args) {
        List<Payment> payments = PaymentDao.getPayments();


       Set<String> failedPayments = payments.stream().filter(fl -> fl.getPaymentStatus().equals("FAILED")).collect(
                        Collectors.groupingBy(Payment::getPayment, Collectors.counting()))
                .entrySet().stream().filter(el -> el.getValue() > 2)
                        .map(Map.Entry::getKey)
                                .collect(Collectors.toSet());

        System.out.println(failedPayments);
    }
}
