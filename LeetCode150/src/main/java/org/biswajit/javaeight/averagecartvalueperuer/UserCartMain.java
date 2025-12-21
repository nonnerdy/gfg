package org.biswajit.javaeight.averagecartvalueperuer;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserCartMain {
    public static void main(String[] args) {
        List<UserCart> userCartList = UserCartDao.getUserCartDetails();

       Map<String,Double> user = userCartList.stream().filter(uc->uc.getCartStatus().equals("CHECKED_OUT"))
                .collect(
                        Collectors.groupingBy(UserCart::getUserName,Collectors.averagingInt(UserCart::getPrice))
                );

        System.out.println(user);
    }
}
