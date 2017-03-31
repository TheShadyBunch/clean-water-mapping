package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by James Johnson on 3/12/17.
 * Modified by Josh Terry on 3/31/17.
 * Class that represents a new PurityReport that has been entered into the system
 */

//TODO: Find a way to actually create a PurityReport
public class PurityReport {
    public int reportID;
    protected double virusPPM;
    protected double contaminantPPM;
    protected WaterReport parent;
    protected OverallWaterCondition overallWaterCondition;

    /**
     * Creates a new PurityReport
     * @param reportID The hash key of this report.
     * @param parent The WaterReport that this points to.
     * @param virusPPM The parts per million of virus
     * @param contaminantPPM The parts per million of contaminant
     * @param overallWaterCondition The overall condition of the water
     */
    public PurityReport(WaterReport parent, double virusPPM, double contaminantPPM,
                        OverallWaterCondition overallWaterCondition, int reportID) {
        this.parent = parent;
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
        return super.toString()
                + "\nOverall Water Condition: " + overallWaterCondition.toString()
                + "\nVirus PPM: " + Double.toString(virusPPM)
                + "\nContaminant PPM: " + Double.toString(contaminantPPM);
    }
}