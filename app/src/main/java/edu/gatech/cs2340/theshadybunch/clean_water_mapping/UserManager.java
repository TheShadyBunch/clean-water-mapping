package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.HashMap;

/**
 * Created by secre on 2/24/2017.
 */

public class UserManager {

    public static final UserManager myUserManager = new UserManager();

    private HashMap<String, edu.gatech.cs2340.theshadybunch.clean_water_mapping.Person> users = new HashMap<>();

    public boolean containsKey(String email) {
        return users.containsKey(email);
    }

    public edu.gatech.cs2340.theshadybunch.clean_water_mapping.Person getPerson(String email) {
        return users.get(email);
    }

    public void putPerson(String email, edu.gatech.cs2340.theshadybunch.clean_water_mapping.Person person) {
        users.put(email, person);
    }

    public boolean validatePassword(String email, String password) {
        if (!users.containsKey(email)) {
            return false;
        }
        return users.get(email).getPassword().equals(password);
    }
}
