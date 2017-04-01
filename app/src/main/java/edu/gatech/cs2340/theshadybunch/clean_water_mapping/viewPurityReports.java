package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collection;

/**
 * Created by Josh on 3/31/2017.
 * Enables users to view purity reports.
 */

public class viewPurityReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_purity_reports);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /**Appends each purity report to the page**/
        TextView report_list = (TextView)findViewById(R.id.purity_reports_list);
        Collection<PurityReport> reports = PurityReportManager.myPurityReports.getAllPurityReports();
        for(PurityReport report : reports){
            report_list.append(report.toString());
            report_list.append("\n");
        }

        /**Returns user to Main Page**/
        Button mReturntoMain = (Button) findViewById(R.id.return_to_main);
        mReturntoMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
                startActivity(i);
            }
        });

    }
}
