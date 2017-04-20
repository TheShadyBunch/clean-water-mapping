package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import android.widget.EditText;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

/**
 * Created on 2/24/2017.
 * @author Kayla Oates
 * @version 1.0
 * A model class for a person using the system.
 */

public abstract class Person implements Serializable {
    private String name;
    private String email;
    private String address;
    private String password;
    private UserTypes userType;
    private boolean isBanned = false;
    private boolean isBlocked = false;
    private List myReports;

    private static Person currentPerson;

    private static final long serialVersionUID = 160518191514L;

    /**
     * @return the person currently logged in to the system
     */
    public static Person getCurrentPerson() {
        return currentPerson;
    }

// --Commented out by Inspection START (4/3/2017 2:37 PM):
//    /**
//     * @return true if someone is currently logged into the system
//     */
//    public static boolean isLoggedIn() {
//        return currentPerson != null;
//    }
// --Commented out by Inspection STOP (4/3/2017 2:37 PM)

    /**
     * Sets the currently logged in user to the given person
     * @param person the person that is logging into the system
     */
    public static void setCurrentPerson(Person person) {
        currentPerson = person;
    }

    /**
     * Creates a new person
     * @param name the person's name
     * @param email the person's email
     * @param address the person's address
     * @param password the person's password
     * @param userType the person's userType
     */
    public Person(String name, String email, String address, String password, UserTypes userType) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.userType = userType;
    }

    /**
     * Creates a new person
     * @param name the person's name
     * @param email the person's email
     * @param address the person's address
     * @param password the person's password
     */
    public Person(String name, String email, String address, String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
        this.userType = UserTypes.USER;
    }

    //TODO: Implement these methods?
    //public void login(){}
    //public void viewWaterReports(){}
    //public void submitSourceReport(){}

    /**
     * @return the person's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the person's email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the person's address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @return the person's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the person's usertype
     */
    public UserTypes getUserType() { return userType; }

    // --Commented out by Inspection START (4/3/2017 2:37 PM):
//    /**
//     * @return the person's user id
//     */
//    public String getId() {
//        return id;
//    }
// --Commented out by Inspection STOP (4/3/2017 2:37 PM)

    /**
     * Sets the user's name
     * @param nName the new name for the user
     */
    public void setName(String nName) {
        name = nName;
    }

    /**
     * sets the user's email
     * @param nEmail the new email for the user
     */
    public void setEmail(String nEmail) {
        email = nEmail;
    }

    /**
     * Sets the user's address
     * @param nAddress the user's new address
     */
    public void setAddress(String nAddress) {
        address = nAddress;
    }

    /**
     * Sets the user's password
     * @param nPassword the user's new password
     */
    public void setPassword(String nPassword) {
        password = nPassword;
    }

    /**
     * Sets the user's usertype
     * @param nUserType the user's new usertype
     */
    public void setUserType(UserTypes nUserType) { userType = nUserType; }

    /**
     * Sets the user's usertype
     * @param nUserType the user's new usertype
     */
    public void setUserType(String nUserType) {
        switch(nUserType) {
            case "WORKER": setUserType(UserTypes.WORKER); break;
            case "MANAGER": setUserType(UserTypes.MANAGER); break;
            case "ADMINISTRATOR": setUserType(UserTypes.ADMINISTRATOR); break;
            default: setUserType(UserTypes.USER); break;
        }
    }

    /**
     *
     */
    public String toString() {
        return "\nName: " + name
                + "\nEmail: " + email
                + "\nAddress: " + address
                + "\nPassword: " + password
                + "\nUsertype: " + userType.toString();
    }

    /**
     * Always treat de-serialization as a full-blown constructor, by
     * validating the final state of the de-serialized object.
     */
    private void readObject(
            ObjectInputStream aInputStream
    ) throws ClassNotFoundException, IOException {
        //always perform the default de-serialization first
        aInputStream.defaultReadObject();
    }

    /**
     * This is the default implementation of writeObject.
     * Customise if necessary.
     */
    private void writeObject(
            ObjectOutputStream aOutputStream
    ) throws IOException {
        //perform the default serialization for all non-transient, non-static fields
        aOutputStream.defaultWriteObject();
    }
}
