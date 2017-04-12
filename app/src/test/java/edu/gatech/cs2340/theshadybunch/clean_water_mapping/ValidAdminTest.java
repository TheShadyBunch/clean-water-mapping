package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

import org.junit.Before;
import org.junit.Test;
import edu.gatech.cs2340.theshadybunch.clean_water_mapping.Person;
import edu.gatech.cs2340.theshadybunch.clean_water_mapping.Administrator;

import static org.junit.Assert.*;

/**
 * @author Josh Terry
 * @version 1.0
 * JUnit Test for several methods in Administrator.java
 */
public class  ValidAdminTest {

    private Administrator admin;

    @Before
    public void setup() {
        admin = new Administrator("Josh", "email", "address", "pass", "id");
    }

    @Test
    public void testAdminConstructorAndGetters() {
        assertFalse("Name mismatch.", !admin.getName().equals("Josh"));
        assertFalse("Email mismatch.", !admin.getEmail().equals("email"));
        assertFalse("Address mismatch.", !admin.getAddress().equals("address"));
        assertFalse("Password mismatch.", !admin.getPassword().equals("pass"));
        assertFalse("ID mismatch.", !admin.getId().equals("id"));
        assertTrue("Name works!", admin.getName().equals("Josh"));
        assertTrue("Email works!", admin.getEmail().equals("email"));
        assertTrue("Address works!", admin.getAddress().equals("address"));
        assertTrue("Password works!", admin.getPassword().equals("pass"));
        assertTrue("ID works!", admin.getId().equals("id"));
    }

    @Test
    public void testPersonSetters() {
        admin.setName("Josh2");
        admin.setEmail("email2");
        admin.setAddress("address2");
        admin.setPassword("pass2");
        assertFalse("setName mismatch.", !admin.getName().equals("Josh2"));
        assertFalse("setEmail mismatch.", !admin.getEmail().equals("email2"));
        assertFalse("setAddress mismatch.", !admin.getAddress().equals("address2"));
        assertFalse("setPassword mismatch.", !admin.getPassword().equals("pass2"));
        assertTrue("setName works!", admin.getName().equals("Josh2"));
        assertTrue("setEmail works!", admin.getEmail().equals("email2"));
        assertTrue("setAddress works!", admin.getAddress().equals("address2"));
        assertTrue("setPassword works!", admin.getPassword().equals("pass2"));
    }
}