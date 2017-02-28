package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.Date;

/**
 * Created by Theresa Mayo on 2/27/2017.
 * Class that represents a new WaterReport that has been entered into the system
 */

public class WaterReport {
    private Person reporter;
    private Date timeReported;
    //when creating a new water report, use the java.util.Date.Date() method
    //which will create a new date object storing the current date/time
    private double latitude;
    private double longitude;
    private WaterType waterType;
    private WaterCondition waterCondition;
    private int reportID;

    /**
     * Creates a new WaterReport
     * @param reporter the person who reported this report
     * @param timeReported a Date object representing when this was reported
     * @param latitude the latitude of this report
     * @param longitude the longitude of this report
     * @param waterType The type of water found (e.g. bottled, stream, lake...)
     * @param waterCondition the condition of the water found (Potable, treatable-clear...)
     */
    public WaterReport(Person reporter, Date timeReported, double latitude, double longitude,
                       WaterType waterType, WaterCondition waterCondition) {
        this.reporter = reporter;
        this.timeReported = timeReported;
        this.latitude = latitude;
        this.longitude = longitude;
        this.waterType = waterType;
        this.waterCondition = waterCondition;

        reportID = 17 * reporter.hashCode() * timeReported.hashCode() * (int) latitude
                * (int) longitude * waterType.hashCode() * waterCondition.hashCode();
    }

    /**
     * Gets the person who reported this WaterReport
     * @return the reporter of this water report
     */
    public Person getReporter() {
        return reporter;
    }

    /**
     * gets the time this water report was reported
     * @return the time this water report was reported
     */
    public Date getTimeReported() {
        return timeReported;
    }

    /**
     * gets the latitude where this water report was made
     * @return the latitude of this water report
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * gets the longitude of this water report
     * @return the longitude of this water report
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * gets the water condition of this water report
     * @return the water condition of this water report
     */
    public WaterCondition getWaterCondition() {
        return waterCondition;
    }

    /**
     * gets the water type of this water report
     * @return the water type of this water report
     */
    public WaterType getWaterType() {
        return waterType;
    }

    /**
     * gets the report ID of this water report
     * @return the report ID of this water report
     */
    public int getReportID() {
        return reportID;
    }

    @Override
    public String toString() {
        String latEnding = (latitude > 0) ? "° North, " : "° South, ";
        String longEnding = (longitude > 0) ? "° East" : "° West";

        return "Water Report made by " + reporter.getName() + " on " + timeReported.toString()
                + "\nLocation: " + Double.toString(latitude) + latEnding + Double.toString(longitude)
                + longEnding + "\nWater Type: " + waterType.toString() + "\nWater Condition: "
                + waterCondition.toString() + "\nReport ID: " + Integer.toString(reportID);
    }
}
