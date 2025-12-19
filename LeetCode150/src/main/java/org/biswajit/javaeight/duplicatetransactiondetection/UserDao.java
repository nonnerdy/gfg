package org.biswajit.javaeight.duplicatetransactiondetection;

import java.util.List;

public class UserDao {

    public static List<User> userTransactions(){

        return List.of(
                new User("Biswajit","T1",100),
                new User("Sudipta","T2",500),
                new User("Biswajit","T3",100),
                new User("Sudipta","T4",300),
                new User("Radharani","T5",500),
                new User("Radharani","T6",500)
        );

    }
}
