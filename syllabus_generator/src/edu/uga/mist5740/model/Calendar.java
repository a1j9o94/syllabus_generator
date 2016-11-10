/**
 * 
 */
package edu.uga.mist5740.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Jenni
 *
 */
public class Calendar implements Serializable{
    private static final long serialVersionUID = 1L;
    private int calendarID;
	private ArrayList<Date> schedule;
	private ArrayList<SpecialEvent> specialEvents;

	/**
	 * @return the calendarID
	 */
	public int getCalendarID() {
		return calendarID;
	}
	
	/**
	 * @ return the schedule of dates for this calendar
	 */
	public ArrayList<Date> getSchedule(){
	    ArrayList<Date> result = new ArrayList<>();
	    for(Date date : schedule){
	        result.add(date);
	    }
	    return result;
	}
	
	/**
     * @ return the special event of dates for this calendar. E.g. Tests or outside of class events
     */
    public ArrayList<SpecialEvent> getSpecialEvents(){
        ArrayList<SpecialEvent> result = new ArrayList<>();
        for(SpecialEvent event : specialEvents){
            result.add(event);
        }
        return result;
    }

	/**
	 * @param calendarID the calendarID to set
	 */
	public void setCalendarID(int calendarID) {
		this.calendarID = calendarID;
	}
	
	/**
	 * @param date The date of a class with the activities being done
	 */
	public void addDateToSchedule(Date date){
	    schedule.add(date);
	}
	
	/**
	 * @param event A special event for the class that needs to be added. E.g. a test outside of normal class time
	 */
	public void addSpecialEvent(SpecialEvent event){
	    specialEvents.add(event);
	}

}
