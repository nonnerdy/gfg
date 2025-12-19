package org.biswajit.javaeight.errorloganalysis;

import java.util.List;

public class LoggingSystemService {
    public static List<LoggingSystem> getLoggingSystemList(){
        return List.of(
                new LoggingSystem("Auth","ERROR"),
                new LoggingSystem("Order","ERROR"),
                new LoggingSystem("Payment","INFO"),
                new LoggingSystem("Order","ERROR")
        );
    }
}
