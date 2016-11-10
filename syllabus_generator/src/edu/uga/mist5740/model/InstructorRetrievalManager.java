package edu.uga.mist5740.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import edu.uga.mist5740.tools.database.SyllabyeDBConnection;

public class InstructorRetrievalManager {
    private static ArrayList<Instructor> instructors;
    private static Connection connection;

    private InstructorRetrievalManager() {

    }

    public static ArrayList<Instructor> getInstructors() throws NamingException, SQLException {
        ArrayList<Instructor> result = new ArrayList<>();
        if (instructors != null) {

        } else {
            connection = SyllabyeDBConnection.getConnection();
            instructors = new ArrayList<>();
            populateInstructors();

        }
        for (Instructor instructor : instructors) {
            result.add(instructor);
        }
        return result;

    }

    private static void populateInstructors() throws SQLException {
        createConnection();
        String query = "SELECT * FROM instructor";
        ResultSet results = null;
        PreparedStatement ps = connection.prepareStatement(query);
        results = ps.executeQuery();
        while (results.next()) {
            addSingleInstructor(results);
        }
    }

    private static void addSingleInstructor(ResultSet row) throws SQLException {
        Instructor instructor = new Instructor();
        instructor.setInstructorID(row.getInt("instructorID"));
        instructor.setFirstName(row.getString("firstName"));
        instructor.setLastName(row.getString("lastName"));
        instructor.setOfficePhone(row.getString("officePhone"));
        instructor.setAddInfo(row.getString("addInfo"));

        addCourses(instructor);
        instructors.add(instructor);
    }

    private static void addCourses(Instructor instructor) throws SQLException {
        String query = "SELECT * FROM course WHERE Instructor_instructorID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, instructor.getInstructorID());
        ResultSet results = ps.executeQuery();
        while (results.next()) {
            Course course = new Course();
            course.setCourseId(results.getInt("courseId"));
            course.setCourseName(results.getString("courseName"));
            course.setAdditionalNotes(results.getString("additionalNotes"));
            addCalendar(course, results.getInt("Calendar_calendarID"));
            addWeightings(course);
            addBooks(course);
            instructor.addCourse(course);
        }
    }

    private static void addCalendar(Course course, int calendarID) throws SQLException {
        Calendar cal = new Calendar();
        cal.setCalendarID(calendarID);
        String query = "SELECT * FROM calendar WHERE calendarID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, cal.getCalendarID());
        ResultSet results = ps.executeQuery();
        while (results.next()) {
            addSchedule(cal);
            addSpecialEvents(cal);
            course.setCalendar(cal);
        }
    }

    private static void addWeightings(Course course) throws SQLException {
        String query = "SELECT * FROM grade WHERE Course_courseID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, course.getCourseId());
        ResultSet results = ps.executeQuery();
        while (results.next()) {
            Grade grade = new Grade();
            grade.setGradeID(results.getInt("gradeID"));
            grade.setGradeName(results.getString("gradeName"));
            grade.setGradeWeight(results.getString("gradeWeight"));
            course.addGade(grade);
        }
    }

    private static void addBooks(Course course) throws SQLException {
        String query = "SELECT * FROM book WHERE Course_courseID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, course.getCourseId());
        ResultSet results = ps.executeQuery();
        while (results.next()) {
            Book book = new Book();
            book.setBookId(results.getInt("bookID"));
            book.setBookName(results.getString("bookName"));
            book.setRequired(results.getBoolean("required"));
            course.addBook(book);
        }
    }

    private static void addSchedule(Calendar cal) throws SQLException {
        String query = "SELECT * FROM date WHERE Calendar_calendarID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, cal.getCalendarID());
        ResultSet results = ps.executeQuery();
        while (results.next()) {
            Date date = new Date();
            date.setIdDate(results.getInt("idDate"));
            date.setDate(results.getDate("date"));
            date.setTopic(results.getString("topic"));
            date.setAssignment(results.getString("assignment"));
            cal.addDateToSchedule(date);
        }
    }

    private static void addSpecialEvents(Calendar cal) throws SQLException {
        String query = "SELECT * FROM specialevent WHERE Calendar_calendarID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, cal.getCalendarID());
        ResultSet results = ps.executeQuery();
        while (results.next()) {
            SpecialEvent event = new SpecialEvent();
            event.setSpecialEventID(results.getInt("specialEventID"));
            event.setDatetime(results.getDate("date"));
            event.setName(results.getString("name"));
            event.setLocation(results.getString("location"));
            cal.addSpecialEvent(event);
        }
    }

    private static void createConnection() {
        if (connection == null) {
            try {
                connection = SyllabyeDBConnection.getConnection();
                instructors = new ArrayList<>();
                populateInstructors();
            } catch (NamingException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
