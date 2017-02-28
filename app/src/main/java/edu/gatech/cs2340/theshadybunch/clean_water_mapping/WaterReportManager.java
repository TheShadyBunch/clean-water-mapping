package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Theresa Mayo on 2/27/2017.
 * Keeps track of the WaterReports currently in the system
 */

public class WaterReportManager {

    //single instance used by the whole app to keep track of water reports
    public static final WaterReportManager myWaterReports = new WaterReportManager();

    private HashMap<Integer,WaterReport> waterReports = new HashMap<>();

    /**
     * adds the report to this WaterReportManager
     * @param waterReport the report to be added
     */
    public void addReport(WaterReport waterReport) {
        waterReports.put(waterReport.getReportID(), waterReport);
    }

    /**
     * gets the report with the given ID
     * @param reportID the id of the report you are trying to get
     * @return the water report with the given ID, or null if no such report exists
     */
    public WaterReport getReport(int reportID) {
        return waterReports.get(reportID);
    }

    /**
     * Gets all the reports in this ReportManager
     * @return a collection of all the reports
     */
    public Collection<WaterReport> getAllReports() {
        return waterReports.values();
    }


}
