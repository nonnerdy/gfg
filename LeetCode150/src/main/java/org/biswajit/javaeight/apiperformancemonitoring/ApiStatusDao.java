package org.biswajit.javaeight.apiperformancemonitoring;

import java.util.List;

public class ApiStatusDao {
    public static List<ApiStatus> getApiStatus(){
        return List.of(
                new ApiStatus("/Login",1000),
                new ApiStatus("/Login",900),
                new ApiStatus("/Login",800),
                new ApiStatus("/Logout",500),
                new ApiStatus("/Logout",450),
                new ApiStatus("/Dashboard",300),
                new ApiStatus("/Dashboard",350)
        );
    }
}
