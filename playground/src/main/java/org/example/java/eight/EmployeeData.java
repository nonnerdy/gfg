package org.example.java.eight;

import java.util.*;

public class EmployeeData {
    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(1, "Alice", "HR", 50000, "New York"),
                new Employee(2, "Bob", "IT", 75000, "Chicago"),
                new Employee(3, "Charlie", "Finance", 65000, "Chicago"),
                new Employee(4, "David", "IT", 80000, "New York"),
                new Employee(5, "Eva", "Finance", 70000, "San Francisco"),
                new Employee(6, "Frank", "HR", 55000, "New York"),
                new Employee(7, "Grace", "IT", 95000, "San Francisco"),
                new Employee(8, "Hank", "Finance", 60000, "Chicago"),
                new Employee(9, "Ivy", "HR", 52000, "San Francisco"),
                new Employee(10, "Jack", "IT", 88000, "New York")
        );
    }
}
