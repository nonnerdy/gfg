package org.biswajit.javaeight.extractuniquecitiessafely;

import java.util.List;

public class UserProfileDao {
    public static List<UserProfile> getUserData(){
        return List.of(
                new UserProfile("U1","Kolkata"),
                new UserProfile("U2",null),
                new UserProfile("U3","Bangalore"),
                new UserProfile("U4","Chennai")
        );
    }
}
