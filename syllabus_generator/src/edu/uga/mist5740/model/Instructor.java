package edu.uga.mist5740.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Instructor implements Serializable{
    private static final long serialVersionUID = 1L;
	private int instructorID;
	private String firstName;
	private String lastName;
	private String officePhone;
	private String addInfo;
	private ArrayList<Course> courses;
	
	/**
	 * @param instructorID
	 */
	public Instructor() {
	}
	/**
	 * @return the instructorID
	 */
	public int getInstructorID() {
		return instructorID;
	}
	/**
	 * @param instructorID the instructorID to set
	 */
	public void setInstructorID(int instructorID) {
		this.instructorID = instructorID;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the officePhone
	 */
	public String getOfficePhone() {
		return officePhone;
	}
	/**
	 * @param officePhone the officePhone to set
	 */
	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}
	/**
	 * @return the addInfo
	 */
	public String getAddInfo() {
		return addInfo;
	}
	/**
	 * @param addInfo the addInfo to set
	 */
	public void setAddInfo(String addInfo) {
		this.addInfo = addInfo;
	}
	/**
	 * @param course A course this instructor teaches
	 */
	public void addCourse(Course course){
	    courses.add(course);
	}
	/**
	 * @return courses All of the courses this instructor has taught
	 */
	public ArrayList<Course> getCourses(){
	    ArrayList<Course> result = new ArrayList<>();
	    for(Course course : courses){
	        result.add(course);
	    }
	    return result;
	}
}
