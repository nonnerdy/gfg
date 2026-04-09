package org.biswajit.javaeight;

class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    // Getters for id and salary as needed

    @Override
    public String toString() {
        return "Employee{" +
                "EmployeeName='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
