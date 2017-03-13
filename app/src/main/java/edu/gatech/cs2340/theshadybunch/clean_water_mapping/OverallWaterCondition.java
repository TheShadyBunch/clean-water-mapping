package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by James Johnson on 3/12/17.
 * an enum that lists the possible conditions of water accepted in a PurityReport
 */

public enum OverallWaterCondition {
    SAFE, TREATABLE, UNSAFE;

    @Override
    public String toString() {
        if (this == SAFE) {
            return "Safe water";
        } else if (this == TREATABLE) {
            return "Treatable water";
        } else {
            return "Unsafe water";
        }
    }
}