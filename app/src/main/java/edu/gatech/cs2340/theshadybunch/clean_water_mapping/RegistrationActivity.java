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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {

    //UI References
    private EditText ETname;
    private EditText ETemail;
    private EditText ETaddress;
    private EditText ETpassword;
    private Button register_button;
    private Button cancel_button;
    private Spinner user_type_spinner;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        //Initialize database
        mDatabase = FirebaseDatabase.getInstance().getReference();

        //Get references to all the UI fields
        ETname = (EditText) findViewById(R.id.ETname);
        ETemail = (EditText) findViewById(R.id.ETemail);
        ETaddress = (EditText) findViewById(R.id.ETaddress);
        ETpassword = (EditText) findViewById(R.id.ETpassword);
        register_button = (Button) findViewById(R.id.register_button);
        cancel_button = (Button) findViewById(R.id.cancel_button);
        user_type_spinner = (Spinner) findViewById(R.id.user_type_spinner);

        ArrayAdapter<edu.gatech.cs2340.theshadybunch.clean_water_mapping.UserTypes> adapter =
                new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, UserTypes.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        user_type_spinner.setAdapter(adapter);



        //If the cancel button is clicked, return to the login screen
        cancel_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        final AlertDialog.Builder badInputAlert = new AlertDialog.Builder(this);


        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (attemptRegistration()) {
                Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
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
        String id = mDatabase.push().getKey();
        UserTypes userType = (UserTypes)user_type_spinner.getSelectedItem();

        /*TODO DELETE: No longer necessary because of hints*/
//        //make sure the user has changed the prefilled text boxes
//        if (name.equals("Name") || email.equals("Email") || address.equals("Home Address")
//                || password.equals("Password")) {
//            return false;
//        }

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

        /*TODO DELETE: may not need UserManager now that Firebase is set up, i.e. clear switch cases
        * of UserManager.myUserManager.putPerson...*/
        switch (userType) {
            case USER:
                User u = new User(name, email, address, password, id);
                mDatabase.child("users").child(id).setValue(u);
                UserManager.myUserManager.putPerson(email, u);
                break;
            case WORKER:
                Worker w = new Worker(name, email, address, password, id);
                mDatabase.child("workers").child(id).setValue(w);
                UserManager.myUserManager.putPerson(email, w);
                break;
            case MANAGER:
                Manager m = new Manager(name, email, address, password, id);
                mDatabase.child("managers").child(id).setValue(m);
                UserManager.myUserManager.putPerson(email, m);
                break;
            case ADMINISTRATOR:
                Administrator a = new Administrator(name, email, address, password, id);
                mDatabase.child("administrators").child(id).setValue(a);
                UserManager.myUserManager.putPerson(email, a);
                break;
        }
        /*TODO DELETE: switch statements replaces if statements*/
//        if (userType.equals(UserTypes.USER)) {
//            UserManager.myUserManager.putPerson(email, new User(name, email, address, password));
//        } else if (userType.equals(UserTypes.WORKER)){
//            UserManager.myUserManager.putPerson(email, new Worker(name, email, address, password));
//        } else if (userType.equals(UserTypes.MANAGER)){
//            UserManager.myUserManager.putPerson(email, new Manager(name, email, address, password));
//        } else if (userType.equals(UserTypes.ADMINISTRATOR)){
//            UserManager.myUserManager.putPerson(email, new Administrator(name, email, address, password));
//        }


        return true;
    }
}
