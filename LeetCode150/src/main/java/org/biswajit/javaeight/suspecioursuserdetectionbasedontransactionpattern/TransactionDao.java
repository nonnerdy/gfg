package org.biswajit.javaeight.suspecioursuserdetectionbasedontransactionpattern;

import java.util.List;

public class TransactionDao {

    public static List<Transaction> getTransactions(){
        return List.of(
                new Transaction("U1", 10000L, 40000L),
                new Transaction("U1", 12000L, 35000L),
                new Transaction("U1", 95000L, 30000L),
                new Transaction("U2", 2000L, 60000L),
                new Transaction("U2", 4000L, 50000L)
        );
    }
}
