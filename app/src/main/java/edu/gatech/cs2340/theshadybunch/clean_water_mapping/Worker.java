package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created on 2/24/2017.
 * @author Kayla Oates
 * @version 1.0
 * Worker is a user that can submit purity reports in our system
 */

class Worker extends Person {

    /**
     * creates a new worker
     * @param name the worker's name
     * @param email the worker's email
     * @param address the worker's address
     * @param password the worker's password
     * @param id the worker's ID number
     */
    public Worker(String name, String email, String address, String password, String id) {
        super(name, email, address, password, id);
    }

    //TODO: Implement this method?
    //public void submitPurityReport(){}
}
