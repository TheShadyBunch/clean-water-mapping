package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by Theresa Mayo on 2/27/2017.
 * an enum that lists the possible conditions of water accepted in a WaterReport
 */

public enum WaterCondition {
    WASTE, TREATABLE_CLEAR, TREATABLE_MUDDY, POTABLE;

    @Override
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
        //TODO: Maybe change the above else to an else if, and create an else that reports an error?
    }
}
