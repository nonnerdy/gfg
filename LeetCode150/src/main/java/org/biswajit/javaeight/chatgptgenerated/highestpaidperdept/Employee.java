package org.biswajit.javaeight.chatgptgenerated.highestpaidperdept;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class Employee {
    private int id;
    private int salary;
    private Departments dept;
}
