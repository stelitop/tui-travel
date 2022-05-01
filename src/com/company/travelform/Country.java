package com.company.travelform;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.Scanner;

public class Country {
    public static List<String> countryList;

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

    public static void loadCountries() {
        countryList = new ArrayList();
        try {
            File file = new File("src/com/company/europe.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String country = scanner.nextLine();
                countryList.add(country.toLowerCase());
            }
        }
        catch (IOException e){

        }
    }
}
