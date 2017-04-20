package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created on 2/24/2017.
 * @author Kayla Oates
 * @version 1.0
 * A user in the system
 */

class User extends Person {

    /**
     * creates a new user
     * @param name the user's name
     * @param email the user's email
     * @param address the user's address
     * @param password the user's password
     */
    public User(String name, String email, String address, String password) {
        super(name, email, address, password, UserTypes.USER);
    }
}
