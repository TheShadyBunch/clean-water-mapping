package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import org.junit.Before;
import org.junit.Test;
import edu.gatech.cs2340.theshadybunch.clean_water_mapping.User;
import edu.gatech.cs2340.theshadybunch.clean_water_mapping.UserManager;

import static org.junit.Assert.*;

/**
 * @author Theresa Mayo
 * @version 1.0
 * JUnit Test for the validatePassword() method in UserManager.java
 */
public class  ValidatePasswordTest {

    private UserManager myUM;

    @Before
    public void setup() {
        myUM = new UserManager();
        myUM.putPerson("tmayo8@gatech.edu",
                new User("Theresa Mayo", "tmayo8@gatech.edu","5136 Antelope Ln", "pass1", "tmayo8"));
    }

    @Test
    public void testValidatePassword() {
        assertFalse("Doesn't detect invalid user", myUM.validatePassword("pshah323@gatech.edu", "pass1"));
        assertFalse("Doesn't detect invalid password", myUM.validatePassword("tmayo8@gatech.edu", "pass2"));
        assertTrue("Doesn't detect valid password", myUM.validatePassword("tmayo8@gatech.edu", "pass1"));
    }
}