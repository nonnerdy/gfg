package org.biswajit.javaeight.errorloganalysis;

public class LoggingSystem {
    private String service;
    private String loggingLevel;

    public LoggingSystem(String service, String loggingLevel) {
        this.service = service;
        this.loggingLevel = loggingLevel;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getLoggingLevel() {
        return loggingLevel;
    }

    public void setLoggingLevel(String loggingLevel) {
        this.loggingLevel = loggingLevel;
    }

    @Override
    public String toString() {
        return "LoggingSystem{" +
                "service='" + service + '\'' +
                ", loggingLevel='" + loggingLevel + '\'' +
                '}';
    }
}
