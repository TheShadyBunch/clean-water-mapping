package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by kvict on 2/24/2017.
 */

public class Administrator extends Person {

    public Administrator(String name, String email, String address, String password, String id) {
        super(name, email, address, password, id);
    }

    public void deletePerson(){}
    public void banPerson(){}
    public void unblockPerson(){}
    public void viewSecurityLog(){}
}
