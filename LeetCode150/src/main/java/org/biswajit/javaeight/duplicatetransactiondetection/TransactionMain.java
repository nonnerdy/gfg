package org.biswajit.javaeight.duplicatetransactiondetection;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
//3
public class TransactionMain {
    public static void main(String[] args) {
        List<User> userTransactionList = UserDao.userTransactions();

       Set<String> userSet =  userTransactionList.stream().collect(
                Collectors.groupingBy(
                        t -> t.getUserName()+"-"+t.getTransactionAmount(),
                        Collectors.counting()
                )
        ).entrySet().stream().filter(e -> e.getValue() > 1)
                .map(e -> e.getKey().split("-")[0])
                .collect(Collectors.toSet());


     Set<String> userSet1 =  userTransactionList.stream().collect(
               Collectors.groupingBy(
                       User::getUserName,
                       Collectors.groupingBy(
                               User::getTransactionAmount,
                               Collectors.counting()
                       )
               )
       ).entrySet().stream()
                       .filter(ut -> ut.getValue().values().stream().anyMatch(c-> c>1))
                               .map(Map.Entry::getKey)
                                       .collect(Collectors.toSet());

        System.out.println(userSet);
        System.out.println(userSet1);
    }
}
