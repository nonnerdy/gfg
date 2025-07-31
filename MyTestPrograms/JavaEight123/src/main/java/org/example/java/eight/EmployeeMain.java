package org.example.java.eight;

import org.example.java.eight.model.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeMain {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "Engineering", 85000, 29, true),
                new Employee(2, "Evan", "Engineering", 88000, 42, true),
                new Employee(3, "Ian", "Engineering", 75000, 25, false),
                new Employee(4, "Bob", "HR", 51000, 31, true),
                new Employee(5, "Fiona", "HR", 53000, 45, false),
                new Employee(6, "Olivia", "HR", 57000, 39, true),
                new Employee(7, "Diana", "Sales", 62000, 28, true),
                new Employee(8, "George", "Sales", 72000, 33, true),
                new Employee(9, "Uma", "Sales", 72000, 26, false),
                new Employee(10, "Evan", "Engineering", 88000, 42, true),   // Duplicate name
                new Employee(11, "Oscar", "Sales", 95000, 41, true),
                new Employee(12, "Isla", "Marketing", 54000, 35, false),
                new Employee(13, "Alice", "Marketing", 56000, 27, true),     // Duplicate name
                new Employee(14, "Zara", "Engineering", 99000, 38, true),
                new Employee(15, "Eli", "HR", 48000, 44, true)
        );




        //List all active employees in the "Engineering" department, sorted by salary descending.

        System.out.println("List all active employees in the \"Engineering\" department, sorted by salary descending.");

        String leftAlignFormat = "| %-4s | %-10s | %-12s | %-8s | %-4s | %-7s |%n";

        System.out.format("+------+------------+--------------+----------+------+---------+%n");
        System.out.format("| ID   | Name       | Department   | Salary   | Age  | Active  |%n");
        System.out.format("+------+------------+--------------+----------+------+---------+%n");



        System.out.format("+------+------------+--------------+----------+------+---------+%n");

        List<Employee> empList = employees.stream().filter(Employee::isActive)
                .filter(engineer -> engineer.getDepartment()
                .equals("Engineering")).sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();

        for (Employee emp : empList) {
            System.out.format(leftAlignFormat, emp.getId(), emp.getName(), emp.getDepartment(), emp.getSalary(), emp.getAge(), emp.isActive());
        }

        System.out.format("+------+------------+--------------+----------+------+---------+%n");



        //Group employees by department and count how many are in each.
        System.out.println("Group employees by department and count how many are in each.");

        /*
        Find the average salary per department.

Find the highest paid employee in each department.

List the names of employees older than 30, sorted alphabetically.

Check if all employees in "HR" are active.

Generate a map of department -> List<Employee Names>
         */

       Map<String,Long> empleeCountMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

        System.out.format("+----------------+--------+%n");
        System.out.format("| Department     | Count  |%n");
        System.out.format("+----------------+--------+%n");

        empleeCountMap.forEach((dept, count) ->
                System.out.format("| %-14s | %-6d |%n", dept, count)
        );

        System.out.format("+----------------+--------+%n");

        // Find the average salary per department.

        System.out.println(" Find the average salary per department.");

        Map<String,Double> avgEmpSalary = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));

        System.out.format("+----------------+---------------+%n");
        System.out.format("| Department     | Avg Salary    |%n");
        System.out.format("+----------------+---------------+%n");

        avgEmpSalary.forEach((dept, count) ->
                System.out.format("| %-14s | %-13f |%n", dept, count)
        );

        System.out.format("+----------------+---------------+%n");



        //Find the highest paid employee in each department.

        System.out.println("Find the highest paid employee in each department.");

       Map<String, Optional<Employee>> highestPaidEmployeeBySalary =  employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.maxBy(Comparator.comparing(Employee::getSalary))));

        System.out.format("+----------------+----------------+-------------+%n");
        System.out.format("| Department     | Name           | Salary      |%n");
        System.out.format("+----------------+----------------+-------------+%n");

        highestPaidEmployeeBySalary.forEach((dept, empOpt) -> {
            if (empOpt.isPresent()) {
                Employee emp = empOpt.get();
                System.out.format("| %-14s | %-14s | %-11.2f |%n", dept, emp.getName(), emp.getSalary());
            }
        });

        System.out.format("+----------------+----------------+-------------+%n");

        //List the names of employees older than 30, sorted alphabetically.

        System.out.println("List the names of employees older than 30, sorted alphabetically.");

        List<String> olderEmployee = employees.stream().filter(employee -> employee.getSalary() > 30).map(Employee::getName).sorted().collect(Collectors.toList());

        System.out.format("+----------------------+%n");
        System.out.format("| Name (Age > 30)      |%n");
        System.out.format("+----------------------+%n");

        olderEmployee.forEach(name ->
                System.out.format("| %-20s |%n", name)
        );

        System.out.format("+----------------------+%n");

    // Check if all employees in "HR" are active.

        boolean listEmployeeInHR = employees.stream().filter(employee -> employee.getDepartment().equals("HR"))
                .allMatch(Employee::isActive);


        System.out.println("Are all HR employees active? " + (listEmployeeInHR ? "Yes ✅" : "No ❌"));

        //Generate a map of department -> List<Employee Names>

        System.out.println("Generate a map of department -> List<Employee Names>");

        Map<String,List<String>> empMapDept =employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName,Collectors.toList())));

        System.out.format("+----------------+------------------------------+%n");
        System.out.format("| Department     | Employee Names               |%n");
        System.out.format("+----------------+------------------------------+%n");

        empMapDept.forEach((dept, names) ->
                System.out.format("| %-14s | %-28s |%n", dept, String.join(", ", names))
        );

        System.out.format("+----------------+------------------------------+%n");


        //Find the second highest salary in the company.

       Optional<Double> secondHighestSalary = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst();

        if (secondHighestSalary.isPresent()) {
            System.out.println("Second highest salary: " + secondHighestSalary.get());
        } else {
            System.out.println("Not enough salary data to determine the second highest.");
        }










        //Find duplicate employee names and how many times they occur.

        Map<String,Long> dupEmp =employees.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting()));

        System.out.println("All employee list -> "+dupEmp);

        Set<String> duplicateEmployees = employees.stream().collect(Collectors.groupingBy(Employee::getName,Collectors.counting())).entrySet().stream().filter((emp)->emp.getValue() > 1)
                        .map(Map.Entry::getKey)
                                .collect(Collectors.toSet());

        System.out.println("Find duplicate employee names and how many times they occur.");

        System.out.println(duplicateEmployees);








        //2. Get the longest name of an active employee.

        Optional<String> longestActiveName = employees.stream().filter(Employee::isActive).map(Employee::getName)
                .max(Comparator.comparing(String::length));



        if (longestActiveName.isPresent()) {
            System.out.println("Longest name among active employees: " + longestActiveName.get());
        } else {
            System.out.println("No active employees found.");
        }


        //3. List employees sorted by department, then by salary (descending).

        List<Employee>  sortedEmployee = employees.stream().sorted(Comparator.comparing(Employee::getDepartment))
                .sorted(Comparator.comparing(Employee::getSalary,Comparator.reverseOrder())).toList();

        System.out.println("List employees sorted by department, then by salary (descending).");

        sortedEmployee.forEach(System.out::println);


        //4. Find departments with employees from all 3 age groups:

        //employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))


        //5. Create a Map<Boolean, List<Employee>> partitioned by whether their name starts with a vowel.


        //6. From each department, pick the employee with the earliest name alphabetically.


        //7. Find the total salary paid to employees whose name has exactly 5 characters.

        //8. Group employees by the first character of their name.

        //9. Generate a map of department -> list of salaries (sorted high to low).

        //10. Check if the list of employees is sorted by age.

        //11. Find the employee(s) with the maximum name length in the company.

        //12. Find if any department has all employees inactive.

        //13. Create a summary string like






    }
}
