package org.biswajit.javaeight.employeeworkloadanomalydetection;


import java.time.LocalDate;

public class WorkLoad {
    private String employee;
    private String project;
    private LocalDate date;
    private int hoursWorked;

    public WorkLoad(String employee, String project, LocalDate date, int hoursWorked) {
        this.employee = employee;
        this.project = project;
        this.date = date;
        this.hoursWorked = hoursWorked;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }


    @Override
    public String toString() {
        return "WorkLoad{" +
                "employee='" + employee + '\'' +
                ", project='" + project + '\'' +
                ", date=" + date +
                ", hoursWorked=" + hoursWorked +
                '}';
    }

}
