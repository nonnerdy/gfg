package org.biswajit.javaeight.mostactiveuser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserEventMain {
    public static void main(String[] args) {
        List<UserEvent> userEvents = UserEventDao.getUserEvents();


        List<String> user = userEvents.stream().collect(
                Collectors.groupingBy(UserEvent::getUserId,Collectors.counting()))
                .entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                        .limit(1).map(Map.Entry::getKey).collect(Collectors.toList());

        System.out.println(user);
    }
}
