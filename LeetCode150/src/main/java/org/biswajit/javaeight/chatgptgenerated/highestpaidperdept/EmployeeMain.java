package org.biswajit.javaeight.chatgptgenerated.highestpaidperdept;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employeeList = List.of(
                new Employee(1,10000,Departments.IT),
                new Employee(2,20000,Departments.FINANCE),
                new Employee(3,5000,Departments.HR),
                new Employee(4,15000,Departments.IT),
                new Employee(5,25000,Departments.HR),
                new Employee(6,30000,Departments.FINANCE)
        );


        //find top salary from each department.

       Map<Departments, Integer> salary =  employeeList.stream().collect(Collectors.groupingBy(
                Employee::getDept,Collectors.maxBy(Comparator.comparing(Employee::getSalary))
        )).entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, v->v.getValue().get().getSalary()));

        System.out.println(salary);
    }
}
