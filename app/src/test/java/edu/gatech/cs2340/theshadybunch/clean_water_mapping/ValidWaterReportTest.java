package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Priyesh Shah on 11/04/2017.
 *
 * Validation test for NewWaterReportActivity
 */

public class ValidWaterReportTest {
    String name = "Priyesh Shah";
    String email = "priyesh_shah@gatech.edu";
    String address = "154 Fifth Street, Atlanta, Georgia 30313";
    String password = "passpass1";
    Administrator myAdmin = new Administrator(name, email, address, password, Integer.toString(17
            * name.hashCode() * email.hashCode() * address.hashCode()
            * password.hashCode()).toString());
    private Date myDate = new Date(2017, 4, 11);
    private WaterReportManager myWaterReportManager;
    private WaterReport myWaterReport = new WaterReport(myAdmin, myDate, 34.034701, -81.124287,
            WaterType.BOTTLED, WaterCondition.POTABLE);

    @Before
    public void setup() {
        myWaterReportManager = new WaterReportManager();
        myWaterReportManager.addReport(myWaterReport);
    }

    @Test
    public void testValidateWaterReport() {
        assertFalse("Invalid water report addition",
                myWaterReportManager.getReport(myWaterReport.getReportID()) != myWaterReport);
        assertFalse("Invalid reporter",
                myWaterReportManager.getReport(myWaterReport.getReportID()).getReporter()
                != myAdmin);
        assertTrue("Works!",
                myWaterReportManager.getReport(myWaterReport.getReportID()) == myWaterReport
                && myWaterReportManager.getReport(myWaterReport.getReportID()).getReporter()
                == myAdmin);
    }
}
