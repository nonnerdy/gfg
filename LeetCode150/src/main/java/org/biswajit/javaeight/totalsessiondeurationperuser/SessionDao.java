package org.biswajit.javaeight.totalsessiondeurationperuser;

import java.time.LocalTime;
import java.util.List;

public class SessionDao {
    public static List<Session> getSessions(){
        return List.of(
                new Session("U1", LocalTime.parse("10:00"),LocalTime.parse("10:30")),
                        new Session("U1", LocalTime.parse("10:00"),LocalTime.parse("10:30")),
                                new Session("U1", LocalTime.parse("10:00"),LocalTime.parse("10:30") )
        );
    }
}
