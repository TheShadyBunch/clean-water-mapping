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
import android.widget.RelativeLayout;
import android.widget.Spinner;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HistoryGraphActivity extends AppCompatActivity {
    protected EditText etLatitude;
    protected EditText etLongitude;
    protected EditText etYear;
    protected boolean isVirus;
    protected String selected;
    protected AlertDialog.Builder mBuilder;
    protected View mView;
    protected Set<Map.Entry<Integer, Double>> points;

    //protected View mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_graph);
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

        etLatitude = (EditText)findViewById(R.id.history_latitude);
        etLongitude = (EditText)findViewById(R.id.history_longitude);
        etYear = (EditText)findViewById(R.id.history_year);
        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Virus");
        spinnerArray.add("Contaminant");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner sItems = (Spinner) findViewById(R.id.virus_or_ppm);
        sItems.setAdapter(adapter);
        selected = sItems.getSelectedItem().toString();

        Button mViewGraphButton = (Button)findViewById(R.id.view_graph);
        final Button mDisplayGraphButton = (Button)findViewById(R.id.display_graph);
        mBuilder = new AlertDialog.Builder(this);
        mViewGraphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etLatitude == null | etLongitude == null || etYear == null) {
                    mBuilder.setTitle("Error invalid inputs");
                    mBuilder.setMessage("Graph cannot be viewed until all fields have valid values");
                    mBuilder.show();
                } else {
                    if (selected.equals("Virus")) {
                        isVirus = true;
                    } else {
                        isVirus = false;
                    }
                    double latitude = Double.parseDouble(etLatitude.getText().toString());
                    double longitude = Double.parseDouble(etLongitude.getText().toString());
                    int year = Integer.parseInt(etYear.getText().toString());
                    HistoryGraph graph = new HistoryGraph(latitude, longitude, isVirus, year);
                    HistoryGraph.setCurrentGraph(graph);

                    mDisplayGraphButton.setVisibility(View.VISIBLE);

                }

            }
        });
        mDisplayGraphButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), GraphActivity.class));



            }
        });


        Button mCancelButton = (Button)findViewById(R.id.cancel_graph);
        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainPageActivity.class));
            }
        });


    }


}
