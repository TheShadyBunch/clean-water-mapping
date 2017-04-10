package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Josh Terry on 3/31/2017.
 * Keeps track of current PurityReports.
 */

public class PurityReportManager {

    public static final PurityReportManager myPurityReports = new PurityReportManager();

    private final HashMap<Integer, PurityReport> purityReports = new HashMap<>();

    /**
     * adds the purity report to this PurityReportManager
     * @param purityReport the purity report to be added
     */
    public void addPurityReport(PurityReport purityReport) {
        purityReports.put(purityReport.getReportID(), purityReport);
    }

    /**
     * gets the purity report with the given ID
     * @param reportID the id of the purity report being looked for
     * @return the purity report with the given ID, or null.
     */
    public PurityReport getPurityReport(int reportID) {
        return purityReports.get(reportID);
    }

    /**
     * Returns every purityReport in this purityReportManager
     * @return every purityReport
     */
    public Collection<PurityReport> getAllPurityReports() {
        return purityReports.values();
    }
}
