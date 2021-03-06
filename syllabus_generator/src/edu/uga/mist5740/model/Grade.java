package edu.uga.mist5740.model;

import java.io.Serializable;

public class Grade implements Serializable {
    private static final long serialVersionUID = 1L;
    private int gradeID;
    private String gradeName;
    private double gradeWeight;

    public int getGradeID() {
        return gradeID;
    }

    public String getGradeName() {
        return gradeName;
    }

    public double getGradeWeight() {
        return gradeWeight;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public void setGradeWeight(double gradeWeight) {
        this.gradeWeight = gradeWeight;
    }
}
