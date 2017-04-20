package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GraphActivity extends AppCompatActivity {
    protected LineChart chart;
    protected HistoryGraph current;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        current = HistoryGraph.getCurrentGraph();
        chart = (LineChart)findViewById(R.id.chart);
        List<Entry> entries = current.getEntries();

        /**for (Map.Entry<Integer, Double> point : points)
        {
            float value = Float.valueOf(String.valueOf(point.getValue()));

            entries.add(new Entry((float)point.getKey(),value));


        }**/
        /**entries.add(new Entry((float)5.5,(float)7.8));
        entries.add(new Entry((float)6.5,(float)8.8));
        entries.add(new Entry((float)7.5,(float)9.8));
        entries.add(new Entry((float)8.5,(float)10.8));**/
        XAxis xAxis = chart.getXAxis();
        xAxis.setLabelCount(9);


        LineDataSet dataSet = new LineDataSet(entries, "Label"); // add entries to dataset
        LineData lineData = new LineData(dataSet);
        chart.setData(lineData);
        chart.invalidate();

    }

}
