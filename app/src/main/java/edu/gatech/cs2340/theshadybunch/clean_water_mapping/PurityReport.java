package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.Date;

/**
 * Created by James Johnson on 3/12/17.
 * Modified by Josh Terry on 3/31/17.
 * Class that represents a new PurityReport that has been entered into the system
 */

//TODO: Find a way to actually create a PurityReport
public class PurityReport extends WaterReport {
    private final int reportID;
    private final double virusPPM;
    private final double contaminantPPM;
    protected WaterReport parent;
    private final OverallWaterCondition overallWaterCondition;
    private final Person reporter;
    private final double latitude;
    private final double longitude;
    private final Date timeReported;

    /**
     * Creates a new PurityReport
     * @param reporter The WaterReport's reporter
     * @param timeReported The date the of this report
     * @param latitude The location of this report
     * @param longitude The location of this report
     * @param virusPPM The parts per million of virus
     * @param contaminantPPM The parts per million of contaminant
     * @param overallWaterCondition The overall condition of the water
     */
    public PurityReport(WaterReport parent, Person reporter, Date timeReported, double latitude, double longitude,
                        OverallWaterCondition overallWaterCondition, double virusPPM, double contaminantPPM) {
        super(reporter, timeReported, latitude, longitude, parent.getWaterType(), parent.getWaterCondition());
        this.reporter = reporter;
        this.timeReported = timeReported;
        this.latitude = latitude;
        this.longitude = longitude;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;
        this.overallWaterCondition = overallWaterCondition;

        this.reportID = 17 * parent.hashCode() * (int) virusPPM
                * (int) contaminantPPM * overallWaterCondition.hashCode();
    }

    /**
     * Gets the overall water condition associated with this PurityReport
     * @return the overall water condition of this purity report
     */
    public OverallWaterCondition getOverallWaterCondition() { return overallWaterCondition; }

    /**
     * Gets the part per million of virus associated with this PurityReport
     * @return the virus PPM of this purity report
     */
    public double getVirusPPM() { return virusPPM; }

    /**
     * Gets the part per million of contaminant associated with this PurityReport
     * @return the contaminant PPM of this purity report
     */
    public double getContaminantPPM() { return contaminantPPM; }

    /**
     * gets the report ID of this purity report
     * @return the report ID of this purity report
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
                + longEnding
                + "\nOverall Water Condition: " + overallWaterCondition.toString()
                + "\nVirus PPM: " + Double.toString(virusPPM)
                + "\nContaminant PPM: " + Double.toString(contaminantPPM)
                + "\nReport ID: " + Integer.toString(reportID);
    }
}