package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.HashMap;

import static edu.gatech.cs2340.theshadybunch.clean_water_mapping.Person.setCurrentPerson;

public class RegistrationActivity extends AppCompatActivity {

    //UI References
    private EditText ETname;
    private EditText ETemail;
    private EditText ETaddress;
    private EditText ETpassword;
    private Button bRegister;
    private Button bCancel;
    private Spinner sUserType;
    private HashMap<String, Person> userList;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        String email = "";
        String password = "";

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            userList = (HashMap<String, Person>) extras.getSerializable("userList");
            email = extras.getString("email");
            password = extras.getString("password");

        }
        userManager = new UserManager(userList);


        //Get references to all the UI fields
        ETname = (EditText) findViewById(R.id.ETname);
        ETemail = (EditText) findViewById(R.id.ETemail);
        ETemail.setText(email, TextView.BufferType.EDITABLE);
        ETaddress = (EditText) findViewById(R.id.ETaddress);
        ETpassword = (EditText) findViewById(R.id.ETpassword);
        ETpassword.setText(password, TextView.BufferType.EDITABLE);

        bRegister = (Button) findViewById(R.id.bRegister);
        bCancel = (Button) findViewById(R.id.bCancel);
        sUserType = (Spinner) findViewById(R.id.sUserType);

        ArrayAdapter<UserTypes> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, UserTypes.values());

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sUserType.setAdapter(adapter);



        //If the cancel button is clicked, return to the login screen
        bCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        final AlertDialog.Builder badInputAlert = new AlertDialog.Builder(this);


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (attemptRegistration()) {
                userList = userManager.saveUsers();
                Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("userList", userList);
                i.putExtras(b);
                startActivity(i);
            } else {
                badInputAlert.setTitle("Whoops! You entered invalid user credentials.");
                badInputAlert.setMessage("Please ensure you have entered something into all fields," +
                        " you have entered a valid email address, and that your password is at " +
                        "least 5 characters long.");
                badInputAlert.show();
            }

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
        UserTypes userType = (UserTypes)sUserType.getSelectedItem();

        //if the email does not contain an @ sign or a dot then it is invalid
        if (!email.contains("@") || !email.contains(".")) {
            return false;
        }

        //split the email around the @ symbol and make sure the domain name is legitimate and
        //there isn't more than one @ symbol in the email address
        String[] splitEmail = email.split("@");

        if (!splitEmail[1].contains(".") || splitEmail[1].charAt(splitEmail[1].length() - 1) == '.'
                || splitEmail.length != 2) {
            return false;
        }

        //require passwords to be at least 5 characters
        if (password.length() < 5) {
            return false;
        }

        switch (userType) {
            case USER:
                User u = new User(name, email, address, password);
                userManager.putPerson(email, u);
                setCurrentPerson(userManager.getPerson(email));
                break;
            case WORKER:
                Worker w = new Worker(name, email, address, password);
                userManager.putPerson(email, w);
                setCurrentPerson(userManager.getPerson(email));
                break;
            case MANAGER:
                Manager m = new Manager(name, email, address, password);
                userManager.putPerson(email, m);
                setCurrentPerson(userManager.getPerson(email));
                break;
            case ADMINISTRATOR:
                Administrator a = new Administrator(name, email, address, password);
                userManager.putPerson(email, a);
                setCurrentPerson(userManager.getPerson(email));
                break;
        }
        userList = userManager.saveUsers();
        return true;
    }
}
