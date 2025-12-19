package org.biswajit.javaeight.errorloganalysis;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LoggingSystemMain {
    public static void main(String[] args) {
        List<LoggingSystem> loggingSystemList = LoggingSystemService.getLoggingSystemList();
        /*
        1.Map<String,Map<String,Integer>>
         */

        List<Map.Entry<String,Long>> logging = loggingSystemList.stream().filter(ls->ls.getLoggingLevel().equalsIgnoreCase("ERROR")).collect(
                Collectors.groupingBy(
                        LoggingSystem::getService,
                Collectors.counting())).entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());


        System.out.println(logging);

    }
}
