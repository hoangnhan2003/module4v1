package com.example.book_store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class History {
    @Id
    private String time;
    private String methodName;

    public History(String time, String methodName) {
        this.time = time;
        this.methodName = methodName;
    }

    public History() {
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
