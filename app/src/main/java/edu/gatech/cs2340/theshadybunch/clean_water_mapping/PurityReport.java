package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.Date;

/**
 * Created by James Johnson on 3/12/17.
 * Class that represents a new PurityReport that has been entered into the system
 */

public class PurityReport extends WaterReport {
    protected double virusPPM;
    protected double contaminantPPM;
    protected OverallWaterCondition overallWaterCondition;

    /**
     * Creates a new PurityReport
     * @param reporter the person who reported this report
     * @param timeReported a Date object representing when this was reported
     * @param latitude the latitude of this report
     * @param longitude the longitude of this report
     * @param waterType The type of water found (e.g. bottled, stream, lake...)
     * @param waterCondition the condition of the water found (Potable, treatable-clear...)
     * @param overallWaterCondition the condition of the water found (Potable, treatable-clear...)
     * @param virusPPM The parts per million of virus
     * @param contaminantPPM The parts per million of contaminant
     */
    public PurityReport(Person reporter, Date timeReported, double latitude, double longitude,
                        WaterType waterType, WaterCondition waterCondition,
                        OverallWaterCondition overallWaterCondition, double virusPPM,
                        double contaminantPPM) {
        super(reporter, timeReported, latitude, longitude, waterType, waterCondition);
        this.overallWaterCondition = overallWaterCondition;
        this.virusPPM = virusPPM;
        this.contaminantPPM = contaminantPPM;

        reportID = 17 * reporter.hashCode() * timeReported.hashCode() * (int) latitude
                * (int) longitude * waterType.hashCode() * waterCondition.hashCode()
                * (int) virusPPM * (int) contaminantPPM * overallWaterCondition.hashCode();
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

    @Override
    public String toString() {
        return super.toString()
                + "\nOverall Water Condition: " + overallWaterCondition.toString()
                + "\nVirus PPM: " + Double.toString(virusPPM)
                + "\nContaminant PPM: " + Double.toString(contaminantPPM);
    }
}