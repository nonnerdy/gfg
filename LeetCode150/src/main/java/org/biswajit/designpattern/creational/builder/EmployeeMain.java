package org.biswajit.designpattern.creational.builder;

import java.util.concurrent.atomic.AtomicInteger;

public class EmployeeMain {
    public static void main(String[] args) {
        Employee emp = new Employee.EmployeeBuilder()
                .setName("Biswajit")
                        .setDept("Engg")
                                .setSalary(100)
                                        .build();

        System.out.println(emp);

        AtomicInteger l = new AtomicInteger();

    }
}
