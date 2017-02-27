package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by Theresa Mayo on 2/27/2017.
 */

public enum WaterCondition {
    WASTE, TREATABLE_CLEAR, TREATABLE_MUDDY, POTABLE;

    public String toString(){
        if (this == WASTE) {
            return "Wastewater";
        } else if (this == TREATABLE_CLEAR) {
            return "Clear treatable water";
        } else if (this == TREATABLE_MUDDY) {
            return "Muddy treatable water";
        } else {
            return "Potable water";
        }
    }
}
