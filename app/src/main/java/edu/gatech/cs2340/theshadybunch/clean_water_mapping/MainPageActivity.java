
package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.JsonWriter;
import android.view.View;
import android.widget.Button;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.io.OutputStream;

public class MainPageActivity extends AppCompatActivity {
    private final Person current = Person.getCurrentPerson();

    private HashMap<String, Person> userList;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            userList = (HashMap<String, Person>) extras.getSerializable("userList");
        }
        userManager = new UserManager(userList);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //BUTTONS
        Button mLogoutButton = (Button) findViewById(R.id.bLogout);
        Button mEditProfileButton = (Button) findViewById(R.id.bProfile);
        Button mNewWaterReportButton = (Button) findViewById(R.id.bNewWaterReport);
        Button mViewMapButton = (Button) findViewById(R.id.bMap);
        Button mViewWaterReportsButton = (Button) findViewById(R.id.bWaterReports);
        Button mViewPurityReportsButton = (Button) findViewById(R.id.bPurityReports);

        //BUTTON VISIBILITY
//        switch(current.getUserType()) {
//            case USER:
//                //mViewUsersButton.setVisibility(View.GONE);
//                //mSLogButton.setVisibility(View.GONE);
//                //mHRepButton.setVisibility(View.GONE);
//                break;
//            case WORKER:
//                //mViewUsersButton.setVisibility(View.GONE);
//                //mHRepButton.setVisibility(View.GONE);
//                mSLogButton.setVisibility(View.GONE);
//                break;
//            case MANAGER:
//                mViewUsersButton.setVisibility(View.GONE);
//                mSLogButton.setVisibility(View.GONE);
//                break;
//            case ADMINISTRATOR:
//                break;
//        }


        //PROFILE
        mEditProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProfileActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("userList",userList);
                i.putExtras(b);
                startActivity(i);
            }
        });

        //NEW WATER REPORT
        mNewWaterReportButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), NewWaterReportActivity.class);
                startActivity(i);
            }
        });

        //VIEW MAP
        mViewMapButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
            }
        });

        //VIEW WATER REPORTS
        mViewWaterReportsButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), viewWaterReports.class));
            }
        });

        //IF MANAGER, VIEW PURITY REPORTS
        if (!(current instanceof Manager)) {
            mViewPurityReportsButton.setVisibility(View.GONE);
        }

        mViewPurityReportsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), viewPurityReports.class));
            }
        });

        //LOGOUT
        mLogoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserManager.currentUser = null;
                Person.setCurrentPerson(null);
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                try {
                    saveUsers();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                startActivity(i);
            }
        });
    }

    public void saveUsers() throws IOException {
        FileOutputStream fos = openFileOutput("users.json", MODE_PRIVATE);
        writeJsonStream(fos);
    }

    public void writeJsonStream(OutputStream out) throws IOException {
        JsonWriter writer = new JsonWriter(new OutputStreamWriter(out, "UTF-8"));
        writer.setIndent("  ");
        //writer.beginObject();
        writeUsersArray(writer, userList);
        //writer.endObject();
        writer.close();
    }

    public void writeUsersArray(JsonWriter writer, HashMap<String, Person> map) throws IOException {
        writer.beginArray();
        for (String key : map.keySet()) {
            writePerson(writer, map.get(key));
        }
        writer.endArray();
    }

    public void writePerson(JsonWriter writer, Person p) throws IOException {
        writer.beginObject();
        writer.name("name").value(p.getName());
        writer.name("email").value(p.getEmail());
        writer.name("address").value(p.getAddress());
        writer.name("password").value(p.getPassword());
        writer.name("usertype").value(p.getUserType().toString());
        writer.endObject();
    }
}
