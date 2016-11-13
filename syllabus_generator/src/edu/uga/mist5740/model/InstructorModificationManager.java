package edu.uga.mist5740.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import edu.uga.mist5740.tools.database.SyllabyeDBConnection;

public class InstructorModificationManager {
    private static Connection connection;

    private InstructorModificationManager() {

    }

    public static void addInstructor(Instructor instructor, ArrayList<Instructor> instructors) throws SQLException {
        createConnection();
        String query = "INSERT INTO instructor (instructorFirstName, instructorLastName, officePhone, additionalInfo) VALUE (?, ?, ?, ?);";

        PreparedStatement ps = connection.prepareStatement(query);

        ps.setString(1, instructor.getFirstName());
        ps.setString(2, instructor.getLastName());
        ps.setString(3, instructor.getOfficePhone());
        ps.setString(4, instructor.getAddInfo());

        ps.executeUpdate();

        String idQuery = "SELECT MAX(instructorID) FROM instructor";
        ps = connection.prepareStatement(idQuery);
        ResultSet maxResults = ps.executeQuery();
        while (maxResults.next()) {
            instructor.setInstructorID(maxResults.getInt(0));
        }

        instructors.add(instructor);
        InstructorRetrievalManager.resetInstructors();
    }

    public static void updateInstructor(Instructor instructor) throws SQLException {
        if (instructor.getInstructorID() >= 0) {
            createConnection();
            String query = "UPDATE instructor SET instructorFirstName = ?, instructorLastName = ?, officePhone = ?, additionalInfo = ? WHERE instructorID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, instructor.getFirstName());
            ps.setString(2, instructor.getLastName());
            ps.setString(3, instructor.getOfficePhone());
            ps.setString(4, instructor.getAddInfo());
            ps.setInt(5, instructor.getInstructorID());
            ps.executeUpdate();
            InstructorRetrievalManager.resetInstructors();
        }else{
            throw new SQLException();
        }
    }

    public static void removeInstructor(int id, ArrayList<Instructor> instructors) throws SQLException {
        createConnection();
        String query = "DELETE FROM instructor WHERE instructorID = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
        InstructorRetrievalManager.resetInstructors();
        for(Instructor instructor : instructors){
            if(instructor.getInstructorID() == id){
                instructors.remove(instructor);
                break;
            }
        }
    }

    public static void addCourseToInstructor(Instructor instructor, Course course)
            throws SQLException {
        if (instructor.getInstructorID() >= 0) {
            createConnection();
            String query = "INSERT INTO course (courseName, courseDescription, Instructor_instructorID, additionalNotes) VALUE (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, course.getCourseName());
            ps.setString(2, course.getCourseDescription());
            ps.setInt(3, instructor.getInstructorID());
            ps.setString(4, course.getAdditionalNotes());
            ps.executeUpdate();
            String idQuery = "SELECT MAX(instructorID) FROM course";
            ps = connection.prepareStatement(idQuery);
            ResultSet maxResults = ps.executeQuery();
            while (maxResults.next()) {
                course.setCourseId(maxResults.getInt(0));
            }
            replaceCourseCalendar(course, course.getCalendar());
            InstructorRetrievalManager.resetInstructors();
            instructor.addCourse(course);
        }else{
            throw new SQLException();
        }
    }

    public static void replaceCourseCalendar(Course course, Calendar cal) throws SQLException {
        if (course.getCourseId() >= 0) {
            createConnection();
            int newId = 0;
            String query1 = "SELECT MAX(calendarID) FROM calendar";
            PreparedStatement ps = connection.prepareStatement(query1);
            ResultSet maxResults = ps.executeQuery();
            while (maxResults.next()) {
                newId = maxResults.getInt(0) + 1;
            }
            cal.setCalendarID(newId);
            String query2 = "INSERT INTO calendar (calendarID) VALUE (?)";
            ps = connection.prepareStatement(query2);
            ps.setInt(1, cal.getCalendarID());
            ps.executeUpdate();
            for (Date date : cal.getSchedule()) {
                String dateQuery = "INSERT INTO date (date, topic, assignment, Calendar_calendarID) VALUE (?, ?, ?, ?)";
                ps = connection.prepareStatement(dateQuery);
                ps.setDate(1, date.getDate());
                ps.setString(2, date.getTopic());
                ps.setString(3, date.getAssignment());
                ps.setInt(4, cal.getCalendarID());
                ps.executeUpdate();
            }
            for (SpecialEvent event : cal.getSpecialEvents()) {
                String specialEventQuery = "INSERT INTO specialevent (date, name, location, Calendar_calendarID) VALUE (?, ?, ?, ?)";
                ps = connection.prepareStatement(specialEventQuery);
                ps.setDate(1, event.getDatetime());
                ps.setString(2, event.getName());
                ps.setString(3, event.getLocation());
                ps.setInt(4, cal.getCalendarID());
                ps.executeUpdate();
            }
            String updateQuery = "UPDATE course SET Calendar_calendarID = ?";
            ps = connection.prepareStatement(updateQuery);
            ps.setInt(1, cal.getCalendarID());
            ps.executeUpdate();
            course.setCalendar(cal);
            InstructorRetrievalManager.resetInstructors();
        }else{
            throw new SQLException();
        }

    }

    public static void replaceCourseWeightings(Course course, ArrayList<Grade> weightings)
            throws SQLException {
        if (course.getCourseId() >= 0) {
            createConnection();
            String deleteQuery = "DELETE FROM grade WHERE Course_courseID = ?";
            PreparedStatement ps = connection.prepareStatement(deleteQuery);
            ps.setInt(1, course.getCourseId());
            ps.executeUpdate();
            course.clearWeightings();

            for (Grade grade : weightings) {
                String gradeQuery = "INSERT INTO grade (gradeName, gradeWeight, Course_courseID) VALUE (?, ?, ?)";
                ps = connection.prepareStatement(gradeQuery);
                ps.setString(1, grade.getGradeName());
                ps.setDouble(2, grade.getGradeWeight());
                ps.setInt(3, course.getCourseId());
                ps.executeUpdate();
                course.addGade(grade);
            }
            InstructorRetrievalManager.resetInstructors();
        } else {
            throw new SQLException();
        }
    }

    public static void addBookToCourse(Course course, Book book) throws SQLException {
        if (course.getCourseId() >= 0) {
            createConnection();
            String query = "INSERT INTO book (bookName, required, Course_courseID) VALUE (?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, book.getBookName());
            ps.setBoolean(2, book.isRequired());
            ps.setInt(3, course.getCourseId());
            ps.executeUpdate();
            InstructorRetrievalManager.resetInstructors();
        } else {
            throw new SQLException();
        }
    }

    public static void removeBookFromCourse(Course course, Book book) throws SQLException {
        if (book.getBookId() >= 0) {
            createConnection();
            String query = "DELETE FROM book WHERE bookID = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, book.getBookId());
            course.removeBook(book);
        }else{
            throw new SQLException();
        }
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
