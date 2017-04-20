package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by James Johnson on 04/11/2017.
 *
 * Validation test for NewPurityReportActivity
 */
 
public class ValidPurityReportTest {
    String name = "James Johnson";
    String email = "jjohnson382@gatech.edu";
    String address = "1097 Mecaslin St. NW, Atlanta, GA 30318";
    String password = "password";
    Worker worker = new Worker(name, email, address, password, Integer.toString(17
        * name.hashCode() * email.hashCode() * address.hashCode()
        * password.hashCode()).toString());
    
    private Date myDate = new Date(2017, 4, 3);
    private Data reportDate = new Date(2017, 4, 11);
    private WaterReportManager myWaterReportManager;
    private WaterReport myWaterReport = new WaterReport(worker, myDate, 34.034701, -81.124287,
            WaterType.BOTTLED, WaterCondition.POTABLE);
    private PurityReport myPurityReport = new PurityReport(myWaterReport, worker,
            myWaterReport.getLatitude(), myWaterReport.getLongitude(),
            OverallWaterCondition.TREATABLE, 1000.0, 3500.0);
    myWaterReport.setPurityReport(myPurityReport);
            
    @Before
    public void setup() {
        myWaterReportManager = new WaterReportManager();
        myWaterReportManager.addReport(myWaterReport);
    }
    
    @Test
    public void testValidateWaterReport() {
        assertFalse("Invalid water report addition",
                myWaterReportManager.getReport(myWaterReport.getReportID()) != myWaterReport);
        assertFalse("Invalid purity report addition",
                myWaterReportManager.getReport(myWaterReport.getReportID()).getPurityReport() != myPurityReport);
        assertFalse("Invalid reporter",
                myWaterReportManager.getReport(myWaterReport.getReportID()).getPurityReport().getReporter()
                != worker);
        assertTrue("Works!",
                myWaterReportManager.getReport(myWaterReport.getReportID()).getPurityReport() == myPurityReport
                && myWaterReportManager.getReport(myWaterReport.getReportID()).getPurityReport().getReporter()
                == worker);
    }
