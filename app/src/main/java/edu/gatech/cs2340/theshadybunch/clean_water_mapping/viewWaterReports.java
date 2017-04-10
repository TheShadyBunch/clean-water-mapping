package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collection;

import static edu.gatech.cs2340.theshadybunch.clean_water_mapping.WaterReport.setCurrentWaterReport;

public class viewWaterReports extends AppCompatActivity {
    private final Person currentPerson = Person.getCurrentPerson();
   // WaterReport currentReport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_view_water_reports);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linlay);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        Collection<WaterReport> reports = WaterReportManager.myWaterReports.getAllReports();
        for(WaterReport report : reports) {
            final TextView textView = new TextView(this);
            textView.setId(report.getReportID());
            textView.setText(report.toString());
            linearLayout.addView(textView, lp);
            if(currentPerson instanceof Manager || currentPerson instanceof  Worker) {
                textView.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v){
                        setCurrentWaterReport(WaterReportManager.myWaterReports.getReport(textView.getId()));
                        Intent intent = new Intent(getApplicationContext(), newPurityReport.class);
                        startActivity(intent);
                    }
                });
            }
        }
        Button mReturnToMain = (Button) findViewById(R.id.main_return);
        mReturnToMain.setText(getString(R.string.return_to_main));
        mReturnToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
                startActivity(i);

            }
        });




        }


        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        /*Appends each water report to the page**/
        //TextView report_list = (TextView)findViewById(R.id.water_reports_list);



        //for(WaterReport report : reports){
          //  report_list.append(report.toString());
            //report_list.append("\n");
        //}

        //report_list.setOnClickListener(new View.OnClickListener(){
          //  public void onClick(View v){
            //    Intent intent = new Intent(this, MapsActivity.class);
              //  startActivity(intent);
            //}
        //});




}
