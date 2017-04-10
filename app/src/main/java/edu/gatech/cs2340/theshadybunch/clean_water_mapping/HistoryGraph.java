package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Theresa Mayo on 3/26/2017.
 */

class HistoryGraph {
    private final double latitude;
    private final double longitude;
    private final int year;

    private final ArrayList<PurityReport> PurityReports = new ArrayList<PurityReport>();

    private final HashMap<Integer, Double> points = new HashMap<Integer, Double>();

    /**
     * Constructor for a new HistoryGraph
     * @param latitude the latitude of the water source a graph is being generated for
     * @param longitude the longitude of the water source a graph is being generated for
     * @param isVirus boolean representing whether the graph is tracking Virus PPM or Contaminant PPM
     * @param year the year the graph is being generated for
     */
    public HistoryGraph(double latitude, double longitude, boolean isVirus, int year) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.year = year;

/*        Collection<WaterReport> allReports = WaterReportManager.myWaterReports.getAllReports();
        for (WaterReport waterReport : allReports) {
            if (waterReport.getLatitude() == this.latitude && waterReport.getLongitude() == this.longitude
                    && waterReport.getTimeReported().getYear() == (year - 1900)
                    && waterReport instanceof PurityReport) {
                PurityReports.add((PurityReport) waterReport);
            }
        }*/

/*        int numReports;
        double reportSum;
        for (int month = 0; month < 12; month++) {
            numReports = 0;
            reportSum = 0.0;
            for (PurityReport purityReport : PurityReports) {
                if (purityReport.getTimeReported().getMonth() == month) {
                    numReports++;
                    if (isVirus) {
                        reportSum = reportSum + purityReport.getVirusPPM();
                    } else {
                        reportSum = reportSum + purityReport.getContaminantPPM();
                    }
                }
            }
            points.put(month, reportSum / numReports);
        }*/
    }

    /**
     * Gets a set of a all the points in this HistoryGraph that can be used to generate the graph in the UI
     * @return a set of a all the points in this HistoryGraph encoded as Map.Entry<Integer, Double>
     */
    public Set<Map.Entry<Integer, Double>> getPoints() {
        return points.entrySet();
    }

    /**
     * @return the latitude of this HistoryGraph
     */

    public double getLatitude() {
        return latitude;
    }

    /**
     * @return the longitude of this HistoryGraph
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * @return the year of this HistoryGraph
     */
    public int getYear() {
        return year;
    }

}
