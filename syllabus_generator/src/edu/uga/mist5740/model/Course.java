package edu.uga.mist5740.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private int courseId;
    private String courseName;
    private String courseDescription;
    private Calendar calendar;
    private String additionalNotes;
    private ArrayList<Grade> weightings;
    private ArrayList<Book> books;

    public Course(){
        weightings = new ArrayList<>();
        books = new ArrayList<>();
    }
    
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public String getAdditionalNotes() {
        return additionalNotes;
    }

    public ArrayList<Grade> getWeightings() {
        ArrayList<Grade> result = new ArrayList<>();
        for (Grade grade : weightings) {
            result.add(grade);
        }
        return result;
    }

    public ArrayList<Book> getBooks() {
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            result.add(book);
        }
        return result;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setAdditionalNotes(String additionalNotes) {
        this.additionalNotes = additionalNotes;
    }

    public void addGade(Grade grade) {
        weightings.add(grade);
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void clearWeightings() {
        for (Grade grade : weightings) {
            weightings.remove(grade);
        }
    }

    public void removeBook(Book toRemove) {
        for (Book book : books) {
            if (book.getBookId() == toRemove.getBookId()) {
                books.remove(book);
            }
        }
    }
}
