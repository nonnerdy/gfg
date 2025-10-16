package org.example.java.eight;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeManupulation {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeData.getEmployees();

        //get count of employees in each department

        Map<String,Long> employeeCountInDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        System.out.println("employees count in each department --> "+employeeCountInDept);

        //find average salary by department

        Map<String,Double> employeeAvgSalary = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));

        System.out.println("average employee salary by department --> "+employeeAvgSalary);

        //3. Highest Salary in Each Department

        Map<String, Optional<Employee>> employeeHighestSalaryInEachDept =employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(
                Comparator.comparing(Employee::getSalary))));

        System.out.println("Highest Salary in Each Department --> ");
        employeeHighestSalaryInEachDept.forEach((dept, empOpt) ->
                System.out.println(dept + " -> " + empOpt.map(Employee::getName).orElse("No Employee")));
    }
}
