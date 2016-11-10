package edu.uga.mist5740.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import edu.uga.mist5740.tools.database.SyllabyeDBConnection;

public class InstructorModificationManager {
    private static Connection connection;

    private InstructorModificationManager() {

    }

    public static void addInstructor(Instructor instructor) throws SQLException {
        createConnection();
    }

    public static void updateInstructor(Instructor instructor) throws SQLException {
        createConnection();
    }

    public static void addCoursesToInstructor(Instructor instructor, Course course)
            throws SQLException {
        createConnection();
    }

    public static void replaceCourseCalendar(Course course, Calendar cal) throws SQLException {
        createConnection();
    }

    public static void replaceCourseWeightings(Course course, ArrayList<Grade> weightings)
            throws SQLException {
        createConnection();
    }

    public static void addBookToCourse(Course course, Book book) throws SQLException {
        createConnection();
    }

    public static void removeBookFromCourse(Course course, Book book) throws SQLException {
        createConnection();
    }

    private static void createConnection() {
        if (connection == null) {
            try {
                connection = SyllabyeDBConnection.getConnection();
            } catch (NamingException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
            }
        }
    }
}
