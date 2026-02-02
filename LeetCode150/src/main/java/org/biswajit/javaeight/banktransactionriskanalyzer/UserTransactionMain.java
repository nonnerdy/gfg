package org.biswajit.javaeight.banktransactionriskanalyzer;

import java.util.List;
import java.util.Map;


public class UserTransactionMain {
    public static void main(String[] args) {
        List<UserTransaction> userTransactions = UserTransactionDao.getUserTransactions();

        /*
        A->[false->value,true->value]
        Map<User,List<Map<Boolean,Integer>>>

         */

        Map<String,List<Map<Boolean,Integer>>> finalList = null;
//        Map<Boolean,Integer> map = new HashMap<>();
//
//        for(UserTransaction ut : userTransactions){
//            finalList.put(ut.getUser(),List.of(map.put(ut.isTransactionStatus(),ut.getAmount())));
//        }

    }
}
