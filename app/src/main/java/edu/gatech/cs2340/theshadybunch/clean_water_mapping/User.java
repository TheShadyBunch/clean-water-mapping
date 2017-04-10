package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by Kayla Oates on 2/24/2017.
 */

public class User extends Person {

    /**
     * creates a new user
     * @param name the user's name
     * @param email the user's email
     * @param address the user's address
     * @param password the user's password
     * @param id the user's id
     */
    public User(String name, String email, String address, String password, String id) {
        super(name, email, address, password, id);
    }
}
