package org.biswajit.javaeight.highestpaidemployee;

import java.util.List;

public class EmployeeDao {

    public static List<Employee> getEmployeeList(){

        return List.of(new Employee("Biswajit",Departments.HR,100000),
                new Employee("Sudipta",Departments.IT,120000),
                new Employee("Anuj",Departments.IT,200000),
                new Employee("Sayantan",Departments.QA,90000),
                new Employee("Tometo",Departments.AI,180000),
                new Employee("Sree",Departments.AI,300000));



    }
}
