package org.biswajit.javaeight.paymentfailuredetection;

import java.util.List;

public class PaymentDao {

    public static List<Payment> getPayments(){
        return List.of(
                new Payment("O1","FAILED"),
                new Payment("O1","FAILED"),
                new Payment("O1","FAILED"),
                new Payment("O2","FAILED"),
                new Payment("O2","SUCCESS")
        );
    }
}
