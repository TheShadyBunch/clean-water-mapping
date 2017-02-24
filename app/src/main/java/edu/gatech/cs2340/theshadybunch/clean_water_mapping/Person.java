package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.List;

/**
 * Created by kvict on 2/24/2017.
 */

public abstract class Person {
    private String name;
    private String email;
    private String address;
    private String password;
    private boolean isBanned = false;
    private boolean isBlocked = false;
    private List myReports;

    public Person(String name, String email, String address, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
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
