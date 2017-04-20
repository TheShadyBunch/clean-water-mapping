package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.gatech.cs2340.theshadybunch.clean_water_mapping.R;

public class ProfileActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etEmail;
    private EditText etAddress;
    private EditText etPassword;
    private final Person current = Person.getCurrentPerson();
    private final String name = current.getName();
    private final String email = current.getEmail();
    private final String address = current.getAddress();
    private final String password = current.getPassword();
    private HashMap<String, Person> userList;
    private UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            userList = (HashMap<String, Person>) extras.getSerializable("userList");
        }
        userManager = new UserManager(userList);

        etName = (EditText)findViewById(R.id.name_edit);
        etName.setText(name);
        etEmail = (EditText)findViewById(R.id.email_edit);
        etEmail.setText(email);
        etAddress = (EditText)findViewById(R.id.address_edit);
        etAddress.setText(address);
        etPassword = (EditText)findViewById(R.id.password_edit);
        etPassword.setText(password);
        /* verifies changes are acceptable/prompts user for password and username**/
        Button mSaveChanges = (Button) findViewById(R.id.save_changes_button);
        final AlertDialog.Builder mBuilder = new AlertDialog.Builder(this);
        mSaveChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (invalidChanges()) {
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
                            if (userManager.validatePassword(mEmail.getText().toString(),mPassword.getText().toString())) {
                                current.setName(etName.getText().toString());
                                current.setEmail(etEmail.getText().toString());
                                current.setAddress(etAddress.getText().toString());
                                current.setPassword(etPassword.getText().toString());
                                userList = userManager.saveUsers();
                                Toast.makeText(ProfileActivity.this, "Changes Accepted",
                                        Toast.LENGTH_SHORT).show();
                                userList = userManager.saveUsers();
                                Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
                                Bundle b = new Bundle();
                                b.putSerializable("userList",userList);
                                i.putExtras(b);
                                startActivity(i);
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
        Button mCancel = (Button) findViewById(R.id.cancel);
        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainPageActivity.class);
                Bundle b = new Bundle();
                b.putSerializable("userList", userList);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }

    /**
     * Checks if the given email is a valid email format
     * @param email the email the user is inputting
     * @return true if the email is valid, false if it is not
     */
    private boolean validEmail(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * Checks to make sure all the information currently entered is valid
     * @return true if they are valid, false if not
     */
    private boolean invalidChanges() {
        return !(validEmail(etEmail.getText().toString()) && (etAddress.getText() != null)
                && (!etAddress.getText().toString().equals(""))
                && (etPassword.getText().toString().length() >= 5));

    }
}