package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.widget.EditText;

import java.util.List;

/**
 * Created by kvict on 2/24/2017.
 */

public abstract class Person {
    private String name;
    private String email;
    private String address;
    private String password;
    private String id;
    private boolean isBanned = false;
    private boolean isBlocked = false;
    private List myReports;
    private static Person currentPerson;

    public static Person getCurrentPerson() {
        return currentPerson;
    }
    public static boolean isLoggedIn() {
        return currentPerson != null;
    }
    public static void setCurrentPerson(Person person) {
        currentPerson = person;
    }

    public Person(String name, String email, String address, String password, String id) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.id = id;
    }

    public void login(){}
    public void viewWaterReports(){}
    public void submitSourceReport(){}

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getAddress() {
        return address;
    }
    public String getPassword() {
        return password;
    }
    public String getId() { return id; }

    public void setName(String nName) {
        name = nName;
    }
    public void setEmail(String nEmail) {
        name = nEmail;
    }
    public void setAddress(String nAddress) {
        name = nAddress;
    }
    public void setPassword(String nPassword) {
        name = nPassword;
    }

}
