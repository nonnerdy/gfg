package org.biswajit.javaeight.frauddetectionusingslidingtimewindow;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserTransactionMain {
    public static void main(String[] args) {
        List<UserTransaction> userTransactions = UserTransactionDao.getUserTransactions();
        /*
        conditions ->
        3 transtaction within 10 minute and amount > 100000
         */

        /*
        1. group by users.
        2. sort by time
        3. take window size of 3 and check the time duration within that window.
            time duration should be within 10 minute
        4. if 3 transactions exists within 10 minutes the check the amount.
        if it exceeds 100000 then that's the output.


         */
int[] arr = {4,3,2,7,8,2,3,1};
        Arrays.sort(arr);
        for(int i : arr){
            System.out.print(i+" ,");
        }

    }
}
