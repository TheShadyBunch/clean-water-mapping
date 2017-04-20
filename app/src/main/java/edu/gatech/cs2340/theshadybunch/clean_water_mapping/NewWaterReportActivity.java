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

//TODO: Create NewPurityReportActivity that extends this class?
public class NewWaterReportActivity extends AppCompatActivity {
    private EditText etLatitude;
    private EditText etLongitude;
    // --Commented out by Inspection (4/3/2017 2:34 PM):private EditText etWaterType;
    // --Commented out by Inspection (4/3/2017 2:35 PM):private EditText etWaterCondition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_water_report);
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
        final Spinner spinner_water_type = (Spinner) findViewById(R.id.spinner_water_type);
        final Spinner spinner_water_condition = (Spinner) findViewById(R.id.spinner_water_condition);
        ArrayAdapter<WaterType> adapt1 =
                new ArrayAdapter<WaterType>(this, android.R.layout.simple_spinner_item, WaterType.values());
        adapt1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_water_type.setAdapter(adapt1);
        ArrayAdapter<edu.gatech.cs2340.theshadybunch.clean_water_mapping.WaterCondition> adapt2 =
                new ArrayAdapter<edu.gatech.cs2340.theshadybunch.clean_water_mapping.WaterCondition>(this, android.R.layout.simple_spinner_item, WaterCondition.values());
        adapt1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_water_condition.setAdapter(adapt2);
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        /*Confirms water report submission and submits it to viewWaterReports**/
        Button mConfirmWaterReportButton = (Button) findViewById(R.id.submit_report);
        mConfirmWaterReportButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Person reporter = Person.getCurrentPerson();
                etLatitude = (EditText) findViewById(R.id.latitude);
                etLongitude = (EditText) findViewById(R.id.longitude);
                WaterType waterType = (WaterType)spinner_water_type.getSelectedItem();
                WaterCondition waterCondition = (WaterCondition)spinner_water_condition.getSelectedItem();
                Date timeReported = new Date();
                double latitude = Double.parseDouble(etLatitude.getText().toString());
                double longitude = Double.parseDouble(etLongitude.getText().toString());
                /*Makes sure something is entered for latitude and longitude before submission**/
                if(etLatitude.getText().toString().equals("") || etLongitude.getText().toString().equals("")) {
                    mBuilder.setTitle("Error Invalid Inputs");
                    mBuilder.setMessage("Latitude and Longitude cannot be empty!");
                    mBuilder.show();
                } else {
                    WaterReport report = new WaterReport(reporter, timeReported, latitude, longitude,
                            waterType, waterCondition);
                    WaterReportManager.myWaterReports.addReport(report);
                    Toast.makeText(NewWaterReportActivity.this, "Report Submitted",
                            Toast.LENGTH_SHORT).show();
                    Intent x = new Intent(getApplicationContext(), MainPageActivity.class);
                    startActivity(x);
                }


            }
        });
        /*Cancels reports and redirects back to Main Activity**/
        Button mCancel = (Button) findViewById(R.id.cancel_report);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(NewWaterReportActivity.this, "Report Canceled",
                        Toast.LENGTH_SHORT).show();
                Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
                startActivity(i);

            }
        });


    }


}
