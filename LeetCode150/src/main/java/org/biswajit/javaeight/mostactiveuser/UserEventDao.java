package org.biswajit.javaeight.mostactiveuser;

import java.util.List;

public class UserEventDao {

    public static List<UserEvent> getUserEvents(){
        return List.of(
                new UserEvent("U1","LOGIN"),
                new UserEvent("U1","LOGOUT"),
                new UserEvent("U1","LOGIN"),
                new UserEvent("U1","DASHBOARD"),
                new UserEvent("U2","LOGIN"),
                new UserEvent("U2","DASHBOARD"),
                new UserEvent("U3","LOGIN"),
                new UserEvent("U3","CLICK"),
                new UserEvent("U3","CLICK"),
                new UserEvent("U3","SCROLL"),
                new UserEvent("U3","LOGOUT")
        );
    }
}
