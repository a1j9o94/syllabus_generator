package edu.uga.mist5740.model;

import java.io.Serializable;

public class Instructor implements Serializable{
    //TODO create fields and getters and setters for all fields
	private int instructorID;
	private String firstName;
	private String lastName;
	private String officePhone;
	private String addInfo;
	
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
	
}
