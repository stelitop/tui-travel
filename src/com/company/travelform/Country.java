package com.company.travelform;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Country {

    public String name;
    public Climate climate;
    /**
     * Key is an activity and the value is the estimated cost per day.
     */
    public Map<Activity, Float> costsPerActivity;
    /**
     * At what place the country ranks in a given activity. 1 is the best and the higher the number the worse it gets.
     */
    public Map<Activity, Integer> activityRanking;
    /**
     * Average hotel cost per day.
     */
    public float hotelCost;

    public Country() {
        this.name = "Name";
        this.climate = Climate.Mild;
        this.costsPerActivity = new HashMap<>();
        this.activityRanking = new HashMap<>();
        this.hotelCost = 0.0f;
    }

    public static Country loadFromFile(String path) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(path));
        Country country = new Country();
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(":");
            if (parts.length == 0) continue;
            if (parts[0].equals("Name")) {
                // format is "Name:<Value>
                if (parts.length != 2) continue;
                country.name = parts[1];
            } else if (parts[0].equals("Climate")) {
                // format is Climate:<Value>
                if (parts.length != 2) continue;
                try {
                    country.climate = Enum.valueOf(Climate.class, parts[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (parts[0].equals("Cost")) {
                // format is "Cost:<Cost per day>"
                if (parts.length != 2) continue;
                try {
                    country.hotelCost = Integer.parseInt(parts[1]);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (parts[0].equals("Activity")) {
                // format is Activity:<Name>:<Cost Per Day>:<Ranking>
                if (parts.length != 4) continue;
                try {
                    Activity activity = Enum.valueOf(Activity.class, parts[1]);
                    country.costsPerActivity.put(activity, Float.parseFloat(parts[2]));
                    country.activityRanking.put(activity, Integer.parseInt(parts[3]));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return country;
    }

    @Override
    public String toString() {
        String ret = "";
        ret += "Name:" + this.name;
        ret += "\nClimate:" + this.climate;
        ret += "\nCost:" + this.hotelCost;
        for (Activity act : Activity.values()) {
            ret += "\nActivity:" + act + ":";
            if (this.costsPerActivity.containsKey(act)) ret += this.costsPerActivity.get(act);
            else ret += "0";
            ret += ":";
            if (this.activityRanking.containsKey(act)) ret += this.activityRanking.get(act);
            else ret += "0";
        }
        return ret;
    }
}
