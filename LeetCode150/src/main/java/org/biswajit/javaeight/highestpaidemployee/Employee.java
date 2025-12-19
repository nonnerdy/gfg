package org.biswajit.javaeight.highestpaidemployee;

public class Employee {
    private String name;
    private Departments departments;
    private int salary;

    public Employee(String name, Departments departments, int salary) {
        this.name = name;
        this.departments = departments;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Departments getDepartments() {
        return departments;
    }

    public void setDepartments(Departments departments) {
        this.departments = departments;
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
                "name='" + name + '\'' +
                ", departments=" + departments +
                ", salary=" + salary +
                '}';
    }
}
