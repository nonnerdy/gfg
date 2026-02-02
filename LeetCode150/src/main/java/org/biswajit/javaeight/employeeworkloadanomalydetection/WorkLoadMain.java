package org.biswajit.javaeight.employeeworkloadanomalydetection;

import java.util.*;
import java.util.stream.Collectors;

public class WorkLoadMain {
    public static void main(String[] args) {
        List<WorkLoad> workLoads = WorkLoadDao.getWorkLoads();
        /*
        1. filter employee who worked for 1 day
        2. project count > 1
        3. calculate hours > 12
         */

        /*
        required data set
            group by employee
            E1={E1,P1,10-12-2025,6},{E1,P1,10-12-2025,5}
         */

//       List<String> overworkedEmployee =  workLoads.stream().collect(Collectors.groupingBy(WorkLoad::getEmployee))
//                .entrySet().stream().
//                filter(
//                        //get project counts > 1
//                        el->{
//                            Set<String> projectCount = new HashSet<>();
//                            for(WorkLoad wl : el.getValue()){
//                                projectCount.add(wl.getProject());
//                            }
//                            return  projectCount.size() > 1;
//                        }
//                ).
//                filter(calculateDay->{
//                    // get total day < 2
//                            long totalDay = 0;
//                            List<LocalDate> dates = calculateDay.getValue().stream().map(WorkLoad::getDate)
//                                    .toList();
//                            LocalDate minDate = Collections.min(dates);
//                            LocalDate maxDate = Collections.max(dates);
//
//                            totalDay = ChronoUnit.DAYS.between(minDate,maxDate);
//
//                            return totalDay < 1;
//                        }
//                        ).
//                filter(
//                        //get total hours worked > 12
//                        calculateHours -> {
//                            long hours = calculateHours.getValue().stream()
//                                    .mapToLong(WorkLoad::getHoursWorked).sum();
//
//                            return hours > 12;
//                        }
//                ).map(Map.Entry::getKey).toList();

        Set<String> overworkedEmployee =
                workLoads.stream()
                        .collect(Collectors.groupingBy(
                                wl -> wl.getEmployee() + "|" + wl.getDate()
                        ))
                        .values()
                        .stream()
                        .filter(dayLogs -> {
                            long totalHours = dayLogs.stream()
                                    .mapToLong(WorkLoad::getHoursWorked)
                                    .sum();

                            long projectCount = dayLogs.stream()
                                    .map(WorkLoad::getProject)
                                    .distinct()
                                    .count();

                            return totalHours > 12 && projectCount > 1;
                        })
                        .map(dayLogs -> dayLogs.get(0).getEmployee())
                        .collect(Collectors.toSet());

        System.out.println(overworkedEmployee);


    }
}
