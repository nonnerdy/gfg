package org.biswajit.javaeight.averagecartvalueperuer;

import java.util.List;

public class UserCartDao {
    public static List<UserCart> getUserCartDetails(){
        return List.of(
                new UserCart("U1",500,"CHECKED_OUT"),
                new UserCart("U1",300,"ABANDONED"),
                new UserCart("U2",400,"CHECKED_OUT")
        );
    }
}
