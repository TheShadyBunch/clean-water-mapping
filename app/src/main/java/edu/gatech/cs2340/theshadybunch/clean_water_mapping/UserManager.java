package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created on 2/24/2017.
 * @author Theresa Mayo
 * @author James Johnson
 * @version 1.0
 * Class to keep track of all the users in the system.
 */

public class UserManager {

    public static Person currentUser = null;
    //this indicates the User currently logged in to the system
    //if no one is logged in it holds null

    // Hash map of user's emails to users
    private HashMap<String, Person> users;

    /**
     * Create a new instance of a UserManager
     * @param userList list of users read in from file
     */
    public UserManager(HashMap userList) {
        if(userList != null) {
            users = userList;
        } else {
            users = new HashMap<>();
        }
    }

    /**
     * Checks to see if the UserManager contains a user with this email
     * @param email the email being checked
     * @return true if it contains this user, false if not
     */
    public boolean containsKey(String email) {
        return users.containsKey(email);
    }

    /**
     * Gets the person in the UserManager with this email
     * @param email the email for the user we are trying to retrieve
     * @return the person with the given email, or null if there is no person with this email
     * in this UserManager
     */
    public Person getPerson(String email) {
        return users.get(email);
    }

    /**
     * Puts the given person into this UserManager
     * @param email the person's email
     * @param person the person object being put in
     */
    public void putPerson(String email, Person person) {
        users.put(email, person);
    }

    /**
     * Checks to see if the given password is valid for the user with the given email
     * @param email the email of the user trying to log in
     * @param password the password we are checking
     * @return true if the password is correct, false if it is not or if the given user doesn't exist
     */
    public boolean validatePassword(String email, String password) {
        return users.containsKey(email) && users.get(email).getPassword().equals(password);
    }

    public HashMap<String, Person> saveUsers() {
        return users;
    }

    public String toJSON() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonFromMap = mapper.writeValueAsString(users);
        System.out.println(jsonFromMap);
        return jsonFromMap;
    }
}
