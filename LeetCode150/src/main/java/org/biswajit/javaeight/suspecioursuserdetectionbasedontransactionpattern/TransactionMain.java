package org.biswajit.javaeight.suspecioursuserdetectionbasedontransactionpattern;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionMain {
    public static void main(String[] args) {
        List<Transaction> transactions = TransactionDao.getTransactions();
        //10 minutes in ms
        // 10 * 1000 * 60
        Long TEN_MINUTES = 600000L;

        List<String> data = transactions.stream().collect(Collectors.groupingBy(Transaction::getTransactionId))
                .entrySet().stream()
                .filter(transact -> {
                    Long transactionAmount = transact.getValue().stream().mapToLong(Transaction::getTransactionAmount).sum();
                    Long transactionTime = transact.getValue().stream().mapToLong(Transaction::getTransactionTime).sum();
                    if (transact.getValue().size() >= 3) {
                        if (transactionTime > TEN_MINUTES)
                            return false;
                        else
                            return transactionAmount > 100000L;
                    } else {
                        return false;
                    }
                }).map(Map.Entry::getKey).toList();

        System.out.println(data);
    }
}
