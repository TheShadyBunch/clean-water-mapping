package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by kvict on 2/24/2017.
 */

public class Administrator extends Person {

    /**
     * creates a new Administrator
     * @param name the administrator's name
     * @param email the administrator's email
     * @param address the administrator's address
     * @param password the administrator's password
     * @param id the administrator's id
     */
    public Administrator(String name, String email, String address, String password, String id) {
        super(name, email, address, password, id);
    }

    //may implement these methods later
    //public void deletePerson(){}
    //public void banPerson(){}
    //public void unblockPerson(){}
    //public void viewSecurityLog(){}
}
