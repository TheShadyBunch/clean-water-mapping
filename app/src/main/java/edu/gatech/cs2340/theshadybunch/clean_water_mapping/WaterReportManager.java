package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by secre on 2/27/2017.
 */

public class WaterReportManager {
    public static final WaterReportManager myWaterReports = new WaterReportManager();

    private HashMap<Integer,WaterReport> waterReports = new HashMap<>();

    public void addReport(WaterReport waterReport) {
        waterReports.put(waterReport.getReportID(), waterReport);
    }

    public WaterReport getReport(int reportID) {
        return waterReports.get(reportID);
    }

    public Collection<WaterReport> getAllReports() {
        return waterReports.values();
    }


}
