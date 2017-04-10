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

public class viewWaterReports extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_water_reports);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /**Appends each water report to the page**/
        TextView report_list = (TextView)findViewById(R.id.water_reports_list);
        Collection<WaterReport> reports = WaterReportManager.myWaterReports.getAllReports();
        for(WaterReport report : reports){
            report_list.append(report.toString());
            report_list.append("\n");
        }
        /**Returns user to Main Page**/
        Button mReturnToMain = (Button) findViewById(R.id.return_to_main);
        mReturnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
                startActivity(i);

            }
        });

        //TODO: Implement a means of editing water reports to add purity variable
    }

}
