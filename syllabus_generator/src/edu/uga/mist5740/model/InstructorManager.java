package edu.uga.mist5740.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import edu.uga.mist5740.tools.database.SyllabyeDBConnection;

public class InstructorManager {
    private static ArrayList<Instructor> instructors;
    private static Connection connection;

    private InstructorManager() {

    }

    public static ArrayList<Instructor> getEducators() throws NamingException, SQLException {
        ArrayList<Instructor> result = new ArrayList<>();
        if (instructors != null) {

        } else {
            connection = SyllabyeDBConnection.getConnection();
            instructors = new ArrayList<>();
            populateEducators();

        }
        for (Instructor instructor : instructors) {
            result.add(instructor);
        }
        return result;

    }
    
    private static void populateEducators() throws SQLException{
        createConnection();
        String query = "SELECT * FROM educator";
        ResultSet results = null;
        PreparedStatement ps = connection.prepareStatement(query);
        results = ps.executeQuery();
        while (results.next()) {
            addSingleEducator(results);
        }
    }
    
    private static void addSingleEducator(ResultSet results) throws SQLException{
        //TODO set all educator fields based on database
    }
    
    private static void createConnection(){
        if (connection == null) {
            try {
                connection = SyllabyeDBConnection.getConnection();
                instructors = new ArrayList<>();
                populateEducators();
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
