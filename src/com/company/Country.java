package com.company;

import java.util.HashMap;
import java.util.Map;

public class Country {

    public String name;
    public Climate climate;
    /**
     * Key is an activity and the value is the estimated cost per day.
     */
    public Map<Activity, Integer> costsPerActivity;
    /**
     * At what place the country ranks in a given activity. 1 is the best and the higher the number the worse it gets.
     */
    public Map<Activity, Integer> activityRanking;
    /**
     * Average hotel cost per day.
     */
    public int hotelCost;

    public Country() {
        this.name = "Name";
        this.climate = Climate.Mild;
        this.costsPerActivity = new HashMap<>();
        this.hotelCost = 0;
    }
}
