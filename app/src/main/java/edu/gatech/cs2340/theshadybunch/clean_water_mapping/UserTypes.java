package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by Theresa Mayo on 2/21/2017.
 * enum that lists the possible types of users
 */

public enum UserTypes {
    USER, WORKER, MANAGER, ADMINISTRATOR;

    @Override
    public String toString() {
        switch(this) {
            case WORKER:
                return "WORKER";
            case MANAGER:
                return "MANAGER";
            case ADMINISTRATOR:
                return "ADMINISTRATOR";
            default:
                return "USER";
        }
    }
}
