package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import com.github.mikephil.charting.data.Entry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by on 3/26/2017.
 * @author Theresa Mayo
 * @version 1.0
 * A graph that shows historic trends in virus or contaminant PPM at a particular water source
 */

class HistoryGraph {
    private final double latitude;
    private final double longitude;
    private final int year;
    private final List<Entry> entries = new ArrayList<Entry>();
    public static HistoryGraph currentGraph = null;


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

        Collection<PurityReport> allReports = PurityReportManager.myPurityReports.getAllPurityReports();
        ArrayList<PurityReport> purityReports = new ArrayList<PurityReport>();
        for (PurityReport purityReport : allReports) {
            if (purityReport.getLatitude() == this.latitude &&
                    purityReport.getLongitude() == this.longitude
                    && purityReport.getTimeReported().getYear() == (year - 1900)) {
                purityReports.add((PurityReport) purityReport);
            }
        }

        int numReports;
        double reportSum;
        for (int month = 0; month < 12; month++) {
            numReports = 0;
            reportSum = 0.0;
            for (PurityReport purityReport : purityReports) {
                if (purityReport.getTimeReported().getMonth() == month) {
                    numReports++;
                    if (isVirus) {
                        reportSum = reportSum + purityReport.getVirusPPM();
                    } else {
                        reportSum = reportSum + purityReport.getContaminantPPM();
                    }
                }
            }
            //points.put(month, reportSum / numReports);
            entries.add(new Entry((float)month,(float)reportSum/numReports));
        }
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

    /**
     *
     * @return the list of entries for this HistoryGraph
     */
    public List<Entry> getEntries(){
        return entries;
    }

    /**
     *
     * @param graph the history graph to set to currentGraph
     */
    public static void setCurrentGraph(HistoryGraph graph) {
        currentGraph = graph;
    }

    /**
     *
     * @return the current HistoryGraph to be displayed
     */
    public static HistoryGraph getCurrentGraph(){
        return currentGraph;
    }


}
