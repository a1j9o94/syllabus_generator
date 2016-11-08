package edu.uga.mist5740.model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import edu.uga.mist5740.tools.database.SyllabyeDBConnection;

public class InstructorManager implements Serializable{
    private static ArrayList<Instructor> instructors;
    private static Connection connection;

    private InstructorManager() {

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
    
    private static void populateInstructors() throws SQLException{
        createConnection();
        String query = "SELECT * FROM instructor";
        ResultSet results = null;
        PreparedStatement ps = connection.prepareStatement(query);
        results = ps.executeQuery();
        while (results.next()) {
            addSingleInstructor(results);
        }
    }
    
    private static void addSingleInstructor(ResultSet results) throws SQLException{
        //TODO set all educator fields based on database
        Instructor instructor = new Instructor();
    }
    
    private static void createConnection(){
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
