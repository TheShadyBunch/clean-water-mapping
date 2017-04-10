package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created on 2/24/2017.
 * @author Kayla Oates
 * @version 1.0
 * A manager is a user type that can perform special tasks in the system
 */

class Manager extends Person {

    /**
     * creates a new Manager
     * @param name the manager's name
     * @param email the manager's email
     * @param address the manager's address
     * @param password the manager's password
     * @param id the manager's id
     */
    public Manager(String name, String email, String address, String password, String id) {
        super(name, email, address, password, id);
    }

    //TODO: Implement the following methods
    //public void submitPurityReport(){}
    //public void viewHistoricalGraph(){}
    //public void deleteReport(){}

}
