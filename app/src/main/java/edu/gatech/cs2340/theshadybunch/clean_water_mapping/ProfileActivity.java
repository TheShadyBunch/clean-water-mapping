package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.gatech.cs2340.theshadybunch.clean_water_mapping.R;

public class ProfileActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etEmail;
    private EditText etAddress;
    private EditText etPassword;
    private Person current = Person.getCurrentPerson();
    private String name = current.getName();
    private String email = current.getEmail();
    private String address = current.getAddress();
    private String password = current.getPassword();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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

        etName = (EditText)findViewById(R.id.name_edit);
        etName.setText(name);
        etEmail = (EditText)findViewById(R.id.email_edit);
        etEmail.setText(email);
        etAddress = (EditText)findViewById(R.id.address_edit);
        etAddress.setText(address);
        etPassword = (EditText)findViewById(R.id.password_edit);
        etPassword.setText(password);
        /** verifies changes are acceptable/prompts user for password and username**/
        Button mSaveChanges = (Button) findViewById(R.id.save_changes_button);
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validChanges()) {
                    mBuilder.setTitle("Error invalid inputs");
                    mBuilder.setMessage("Changes cannot be accepted until all fields have valid values");
                    mBuilder.show();

                } else {
                    View mView = getLayoutInflater().inflate(R.layout.dialog_profile, null);
                    final EditText mEmail = (EditText) mView.findViewById(R.id.reenter_email);
                    final EditText mPassword = (EditText) mView.findViewById(R.id.reenter_password);
                    Button mConfirm = (Button) mView.findViewById(R.id.confirm);
                    mConfirm.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            if (UserManager.myUserManager.validatePassword(mEmail.getText().toString(),mPassword.getText().toString())) {
                                current.setName(etName.getText().toString());
                                current.setEmail(etEmail.getText().toString());
                                current.setAddress(etAddress.getText().toString());
                                current.setPassword(etPassword.getText().toString());
                                Toast.makeText(ProfileActivity.this, "Changes Accepted",
                                        Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(ProfileActivity.this, "Changes not Accepted",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    mBuilder.setView(mView);
                    AlertDialog dialog = mBuilder.create();
                    dialog.show();







                }


            }
        });
        Button mLogout = (Button) findViewById(R.id.logout);
        mLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserManager.currentUser = null;
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);

            }
        });
    }
    public boolean validEmail(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private boolean validChanges() {
        return (validEmail(etEmail.getText().toString()) && (etAddress.getText() != null)
                && (!etAddress.getText().toString().equals(""))
                && (etPassword.getText().toString().length() >= 5));

    }


}

