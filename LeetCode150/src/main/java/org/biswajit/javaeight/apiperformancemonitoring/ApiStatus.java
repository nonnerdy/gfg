package org.biswajit.javaeight.apiperformancemonitoring;

public class ApiStatus {
    private String endPoint;
    private int time;

    public ApiStatus(String endPoint, int time) {
        this.endPoint = endPoint;
        this.time = time;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "ApiStatus{" +
                "endPoint='" + endPoint + '\'' +
                ", time=" + time +
                '}';
    }
}
