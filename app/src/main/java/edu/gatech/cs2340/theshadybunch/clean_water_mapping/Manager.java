package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by kvict on 2/24/2017.
 */

public class Manager extends Person {

    /**
     * creates a new Manager
     * @param name the manager's name
     * @param email the manager's email
     * @param address the manager's address
     * @param password the manager's password
     */
    public Manager(String name, String email, String address, String password) {
        super(name, email, address, password, UserTypes.MANAGER);
    }

    //TODO: Implement the following methods
    //public void submitPurityReport(){}
    //public void viewHistoricalGraph(){}
    //public void deleteReport(){}

}
