package org.biswajit.javaeight.highestpaidemployee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.Map.Entry;
//2
public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employeeList = EmployeeDao.getEmployeeList();

        Map<Departments,Employee> departmentsStringMap= employeeList.stream().collect(Collectors.groupingBy(

                Employee::getDepartments, Collectors.collectingAndThen(
                        Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)), Optional::get)));


        for(Entry<Departments,Employee> employeeMap:departmentsStringMap.entrySet()){
            System.out.println("Employee Name : "+employeeMap.getValue().getName()
            +", Department : "+employeeMap.getKey() + ", Salary : "+employeeMap.getValue().getSalary());
        }
    }
}
