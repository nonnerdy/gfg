package org.biswajit.javaeight.totalsessiondeurationperuser;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SessionMain {
    /*
    .entrySet().stream()
                .map(el->{
                    el.getValue().stream().map(e->{
                        long minutes = ChronoUnit.MINUTES.between(e.getSessionStart(), e.getSessionEnd());
                        return minutes;
                    })
                            .
     */
    public static void main(String[] args) {
        List<Session> sessionList = SessionDao.getSessions();

        Map<String, Long> time = sessionList.stream().collect(Collectors.groupingBy(Session::getSession,
                Collectors.summingLong(s ->
                        ChronoUnit.MINUTES.between(s.getSessionStart(), s.getSessionEnd()))));


        System.out.println(time);


    }
}
