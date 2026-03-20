package org.biswajit.designpattern.creational.builder;

public class Employee {
    private String name;
    private String dept;
    private int salary;

    private Employee(EmployeeBuilder empb) {
        this.name = empb.name;
        this.dept = empb.dept;
        this.salary = empb.salary;
    }

    @Override
    public String toString() {
        return "EmployeeBuilder{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }

    public static class EmployeeBuilder{
        private String name;
        private String dept;
        private int salary;


        public EmployeeBuilder setName(String name) {
            this.name = name;
            return this;
        }


        public EmployeeBuilder setDept(String dept) {
            this.dept = dept;
            return this;
        }

        public EmployeeBuilder setSalary(int salary) {
            this.salary = salary;
            return this;
        }



        public Employee build(){
            return new Employee(this);
        }
    }
}
