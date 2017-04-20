package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Date;

public class newPurityReport extends AppCompatActivity {
   // private final WaterReport parentReport = WaterReport.getCurrentWaterReport();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_purity_report);
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
        final Spinner overall_condition = (Spinner) (findViewById(R.id.overall_condition));

        ArrayAdapter<OverallWaterCondition> adapt =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, OverallWaterCondition.values());
        adapt.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        overall_condition.setAdapter(adapt);

        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);

        Button mConfirmPurityButton = (Button) findViewById(R.id.submit_purity);
        mConfirmPurityButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Person reporter = Person.getCurrentPerson();
                EditText etLatitude = (EditText) findViewById(R.id.purity_latitude);
                EditText etLongitude = (EditText) findViewById(R.id.purity_longitude);
                EditText etVirusPPM = (EditText) findViewById(R.id.virus_ppm);
                EditText etCppm = (EditText) findViewById(R.id.c_ppm);
                OverallWaterCondition condition = (OverallWaterCondition)overall_condition.getSelectedItem();
                double latitude = Double.parseDouble(etLatitude.getText().toString());
                double longitude = Double.parseDouble(etLongitude.getText().toString());
                double virus = Double.parseDouble(etVirusPPM.getText().toString());
                double c = Double.parseDouble(etCppm.getText().toString());
                Date date = new Date();
                /*Makes sure something is entered for latitude and longitude before submission**/
                if(etLatitude == null || etLongitude == null || etCppm == null || etVirusPPM == null) {
                    mBuilder.setTitle("Error Invalid Inputs");
                    mBuilder.setMessage("All values must be filled");
                    mBuilder.show();
                } else {
                    PurityReport report = new PurityReport(reporter, date, latitude, longitude, condition, virus, c);
                    PurityReportManager.myPurityReports.addPurityReport(report);
                    Toast.makeText(newPurityReport.this, "Report Submitted",
                            Toast.LENGTH_SHORT).show();
                    Intent x = new Intent(getApplicationContext(), MainPageActivity.class);
                    startActivity(x);
                }
            }
        });
        /*Cancels reports and redirects back to Main Activity**/
        Button mCancel = (Button) findViewById(R.id.cancel_purity);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(newPurityReport.this, "Report Canceled",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
                startActivity(i);

            }
        });





    }




}
