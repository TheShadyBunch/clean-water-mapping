package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.content.Intent;
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

import edu.gatech.cs2340.theshadybunch.clean_water_mapping.R;

public class ProfileActivity extends AppCompatActivity {
    User dummy = new User("Kayla Oates", "koates7", "harrishall", "chimichangas");
    private EditText name;
    private EditText email;
    private EditText address;
    private EditText password;

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

        name = (EditText)findViewById(R.id.name_edit);
        name.setText(dummy.getName());
        email = (EditText)findViewById(R.id.email_edit);
        email.setText(dummy.getEmail());
        address = (EditText)findViewById(R.id.address_edit);
        address.setText(dummy.getAddress());
        password = (EditText)findViewById(R.id.password_edit);
        password.setText(dummy.getPassword());

        Button mSaveChanges = (Button) findViewById(R.id.save_changes_button);
        mSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validSave();
            }
        });



        /**If changes are valid(check for that) have them reenter previous password to change info**/



    }

    private boolean validEmail(CharSequence email) {
        return email != null && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
    AlertDialog.Builder errorMessage = new AlertDialog.Builder(this);
    private void validSave() {
        if (validEmail(email.getText().toString()) && name.getText().toString().length() > 0
                && email.getText().toString().length() > 0
                && address.getText().toString().length() > 0
                && password.getText().toString().length() >= 5) {
            name.setText(name.getText().toString());
            email.setText(email.getText().toString());
            address.setText(address.getText().toString());
            password.setText(password.getText().toString());
        } else {
            errorMessage.setTitle("Cannot save changes");
            errorMessage.setMessage("Name and  home address cannot be blank"
                    + "Password must be 5 characters long" + "Email address must be vaild");
            errorMessage.show();
        }

    }


}
