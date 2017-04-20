package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by kvict on 2/24/2017.
 */

public class User extends Person {

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
