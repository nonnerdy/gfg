package org.biswajit.javaeight.frauddetectionusingslidingtimewindow;

import java.time.LocalTime;
import java.util.List;

public class UserTransactionDao {
    public static List<UserTransaction> getUserTransactions(){
        return List.of(
                new UserTransaction("U1", LocalTime.of(10,0),40000),
                new UserTransaction("U1",LocalTime.of(10,5),35000),
                new UserTransaction("U1",LocalTime.of(10,8),30000),
                new UserTransaction("U1",LocalTime.of(11,0),50000),
                new UserTransaction("U2",LocalTime.of(10,0),40000),
                new UserTransaction("U2",LocalTime.of(11,0),70000)
        );
    }
}
