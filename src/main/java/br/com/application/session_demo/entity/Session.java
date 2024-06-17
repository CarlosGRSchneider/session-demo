package br.com.application.session_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Session {

    @Id
    private String name;

    private int count = 0;

    private String sessionId;

    @Deprecated
    public Session(){}

    public Session(String name, String sessionId) {
        this.name = name;
        this.sessionId = sessionId;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void increment() {
        this.count++;
    }
}
