package org.biswajit.javaeight.banktransactionriskanalyzer;

import java.util.List;

public class UserTransactionDao {
    /*
    user=A amount=100 success=true
user=A amount=200 success=false
user=A amount=300 success=false
user=B amount=500 success=true
user=B amount=100 success=false
     */

    public static List<UserTransaction> getUserTransactions(){
        return List.of(
                new UserTransaction("A",100,true),
                new UserTransaction("A",200,false),
                new UserTransaction("B",500,true),
                new UserTransaction("B",100,false),
                new UserTransaction("A",300,false)
        );
    }
}
