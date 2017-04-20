package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by on 2/24/2017.
 * @author Kayla Oates
 * @version 1.0
 * Administrator is a User Type that can manage other user accounts and perform administrative
 * tasks in the system
 */

class Administrator extends Person {

    /**
     * creates a new Administrator
     * @param name the administrator's name
     * @param email the administrator's email
     * @param address the administrator's address
     * @param password the administrator's password
     */
    public Administrator(String name, String email, String address, String password) {
        super(name, email, address, password, UserTypes.ADMINISTRATOR);
    }

    //TODO: Implement the following methods
    //public void deletePerson(){}
    //public void banPerson(){}
    //public void unblockPerson(){}
    //public void viewSecurityLog(){}
}
