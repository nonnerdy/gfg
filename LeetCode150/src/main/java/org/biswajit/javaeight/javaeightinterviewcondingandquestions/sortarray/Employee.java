package org.biswajit.javaeight.javaeightinterviewcondingandquestions.sortarray;

public class Employee {
    private String name;
    private Long salary;
    private String department;

    public Employee(String name, Long salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }

    public  String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }


}
