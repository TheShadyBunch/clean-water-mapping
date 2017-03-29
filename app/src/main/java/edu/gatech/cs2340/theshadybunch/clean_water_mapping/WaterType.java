package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by secre on 2/27/2017.
 * Enum isting possible types of water accepted by the water report
 */

public enum WaterType {
    BOTTLED, WELL, STREAM, LAKE, SPRING;

    @Override
    public String toString() {
        if (this == BOTTLED) {
            return "Bottled";
        } else if (this == WELL) {
            return "Well";
        } else if (this == STREAM) {
            return "Stream";
        } else if (this == LAKE) {
            return "Lake";
        } else {
            return "Spring";
        }
        //TODO: Maybe change the above else to an else if, and create an else that reports other?
    }
}
