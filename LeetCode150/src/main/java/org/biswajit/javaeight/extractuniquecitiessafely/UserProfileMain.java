package org.biswajit.javaeight.extractuniquecitiessafely;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class UserProfileMain {
    public static void main(String[] args) {
        List<UserProfile> userProfiles = UserProfileDao.getUserData();

        /*
        aggreagate the cities and also do the null check
         */

     List<String> a = userProfiles.stream().filter(up->up.getAddress()!=null).map(UserProfile::getAddress).distinct().collect(Collectors.toList());


        System.out.println(a);

    }
}
