package edu.gatech.cs2340.theshadybunch.clean_water_mapping;

/**
 * Created by secre on 2/27/2017.
 */

public enum WaterType {
    BOTTLED, WELL, STREAM, LAKE, SPRING;

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
    }
}
