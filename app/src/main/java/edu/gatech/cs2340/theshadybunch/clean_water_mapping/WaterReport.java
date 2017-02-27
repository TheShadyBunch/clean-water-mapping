package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.Date;

/**
 * Created by Theresa Mayo on 2/27/2017.
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

    public Person getReporter() {
        return reporter;
    }

    public Date getTimeReported() {
        return timeReported;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public WaterCondition getWaterCondition() {
        return waterCondition;
    }

    public WaterType getWaterType() {
        return waterType;
    }

    public int getReportID() {
        return reportID;
    }

    public String toString() {
        String latEnding = (latitude > 0) ? "° North, " : "° South, ";
        String longEnding = (longitude > 0) ? "° East" : "° West";

        return "Water Report made by " + reporter.getName() + " on " + timeReported.toString()
                + "\nLocation: " + Double.toString(latitude) + latEnding + Double.toString(longitude)
                + longEnding + "\nWater Type: " + waterType.toString() + "\nWater Condition: "
                + waterCondition.toString() + "\nReport ID: " + Integer.toString(reportID);
    }
}
