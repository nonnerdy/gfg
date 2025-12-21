package org.biswajit.javaeight.apiperformancemonitoring;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ApiStatusMain {
    public static void main(String[] args) {
        List<ApiStatus> apiStatuses = ApiStatusDao.getApiStatus();

      Map<String,Double> apiStatus = apiStatuses.stream().collect(
                Collectors.groupingBy(ApiStatus::getEndPoint,Collectors.averagingInt(
                        ApiStatus::getTime
                )
        ));

        System.out.println(apiStatus);
    }
}
