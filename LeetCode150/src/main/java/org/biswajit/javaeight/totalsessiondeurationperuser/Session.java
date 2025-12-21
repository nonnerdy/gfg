package org.biswajit.javaeight.totalsessiondeurationperuser;

import java.time.LocalTime;

public class Session {
    private String session;
    private LocalTime sessionStart;
    private LocalTime sessionEnd;

    public Session(String session, LocalTime sessionStart, LocalTime sessionEnd) {
        this.session = session;
        this.sessionStart = sessionStart;
        this.sessionEnd = sessionEnd;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public LocalTime getSessionStart() {
        return sessionStart;
    }

    public void setSessionStart(LocalTime sessionStart) {
        this.sessionStart = sessionStart;
    }

    public LocalTime getSessionEnd() {
        return sessionEnd;
    }

    public void setSessionEnd(LocalTime sessionEnd) {
        this.sessionEnd = sessionEnd;
    }

    @Override
    public String toString() {
        return "Session{" +
                "session='" + session + '\'' +
                ", sessionStart=" + sessionStart +
                ", sessionEnd=" + sessionEnd +
                '}';
    }
}
