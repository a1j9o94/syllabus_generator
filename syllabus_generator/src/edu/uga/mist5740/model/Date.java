package edu.uga.mist5740.model;

import java.io.Serializable;

public class Date implements Serializable {
    private static final long serialVersionUID = 1L;
    private int idDate;
    private java.sql.Date date;
    private String topic;
    private String assignment;

    public int getIdDate() {
        return idDate;
    }

    public java.sql.Date getDate() {
        return date;
    }

    public String getTopic() {
        return topic;
    }

    public String getAssignment() {
        return assignment;
    }

    public void setIdDate(int idDate) {
        this.idDate = idDate;
    }

    public void setDate(java.sql.Date date) {
        this.date = date;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setAssignment(String assignment) {
        this.assignment = assignment;
    }
}
