/**
 * 
 */
package edu.uga.mist5740.model;

import java.io.Serializable;

/**
 * @author Jenni
 *
 */
public class Calendar implements Serializable{
	private int calendarID;

	/**
	 * @param calendarID
	 */
	public Calendar() {
		
	}

	/**
	 * @return the calendarID
	 */
	public int getCalendarID() {
		return calendarID;
	}

	/**
	 * @param calendarID the calendarID to set
	 */
	public void setCalendarID(int calendarID) {
		this.calendarID = calendarID;
	}

}
