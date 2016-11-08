/**
 * 
 */
package edu.uga.mist5740.model;

import java.io.Serializable;

/**
 * @author Adrian
 *
 */
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private int bookId;
    private String bookName;
    private boolean required;

    /**
     * @return the bookId of this book in the database
     */
    public int getBookId() {
        return bookId;
    }

    /**
     * @return This books name
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * @return Whether or not this book is required for a given course
     */
    public boolean isRequired() {
        return required;
    }

    /**
     * @param Sets
     *            the database ID of this book
     */
    public void setBookId(int id) {
        this.bookId = id;
    }

    /**
     * @param Sets
     *            the name of this book
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * @param Sets
     *            the requried status of this book
     */
    public void setRequired(boolean required) {
        this.required = required;
    }
}
