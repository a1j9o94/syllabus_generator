/**
 * 
 */
package edu.uga.mist5740.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author jennicosler
 *
 */
public class SpecialEvent implements Serializable {
    private static final long serialVersionUID = 1L;
    private int specialEventID;
    private Date datetime;
    private String name;
    private String location;

    /**
     * 
     */
    public SpecialEvent() {
    }

    /**
     * @return the specialEventID
     */
    public int getSpecialEventID() {
        return specialEventID;
    }

    /**
     * @param specialEventID
     *            the specialEventID to set
     */
    public void setSpecialEventID(int specialEventID) {
        this.specialEventID = specialEventID;
    }

    /**
     * @return the datetime
     */
    public Date getDatetime() {
        return datetime;
    }

    /**
     * @param datetime
     *            the datetime to set
     */
    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location
     *            the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

}
