package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


//TODO: Figure out why the main page is not populating
public class MainPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button mLogoutButton = (Button) findViewById(R.id.logout_button);

        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserManager.currentUser = null;
                Person.setCurrentPerson(null);
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);

            }
        });

        Button mEditProfileButton = (Button) findViewById(R.id.edit_profile_button);
        mEditProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
            }
        });
        Button mNewWaterReportButton = (Button) findViewById(R.id.new_water_report);
        mNewWaterReportButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), NewWaterReportActivity.class));

            }
        });
        Button mViewMapButton = (Button) findViewById(R.id.view_map_button);
        mViewMapButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));

            }
        });
        Button mViewWaterReportsButton = (Button) findViewById(R.id.view_water_reports);
        mViewWaterReportsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), viewWaterReports.class));

            }
        });







    }




}
