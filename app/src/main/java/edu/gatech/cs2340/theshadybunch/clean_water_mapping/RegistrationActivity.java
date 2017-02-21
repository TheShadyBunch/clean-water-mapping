package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistrationActivity extends AppCompatActivity {

    //UI References
    private EditText ETname;
    private EditText ETemail;
    private EditText ETaddress;
    private EditText ETpassword;
    private Button register_button;
    private Button cancel_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //Get references to all the UI fields
        ETname = (EditText) findViewById(R.id.ETname);
        ETemail = (EditText) findViewById(R.id.ETemail);
        ETaddress = (EditText) findViewById(R.id.ETaddress);
        ETpassword = (EditText) findViewById(R.id.ETpassword);
        register_button = (Button) findViewById(R.id.register_button);
        cancel_button = (Button) findViewById(R.id.cancel_button);


        //If the cancel button is clicked, return to the login screen
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);

            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }

    /**
     * Method called when register button is clicked, attempts to register a new user
     * @return false if the registration is unsuccessful because the user entered invalid
     * information.
     */
    private boolean attemptRegistration() {
        String name = ETname.getText().toString();
        String email = ETemail.getText().toString();
        String address = ETaddress.getText().toString();
        String password = ETpassword.getText().toString();

        //if the email does not contain an @ sign or a dot then it is invalid
        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }

        //split the email around the @ symbol and make sure the domain name is legitimate and
        //there isn't more than one @ symbols in the email address
        String[] splitEmail = email.split("@");

        if (!splitEmail[1].contains(".") || splitEmail[1].charAt(splitEmail[1].length() - 1) == '.'
                || splitEmail.length != 2) {
            return false;
        }


    }
}
