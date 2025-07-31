package org.example.java.collection;

import java.util.Objects;

public class Employee {
    private int empId;
    private String name;
    private String department;
    private int salary;

    public Employee(int empId, String name, String department, int salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;
        return empId == employee.empId && salary == employee.salary && Objects.equals(name, employee.name) && Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        int result = empId;
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(department);
        result = 31 * result + salary;
        return result;
    }


//    @Override
//    public int compareTo(Employee o) {
//        //We will sort the employee based on age in ascending order
//        //returns a negative integer, zero, or a positive integer as this employee age
//        //is less than, equal to, or greater than the specified object.
//        return (this.salary - o.salary);
//    }
}
