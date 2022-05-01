package com.company.travelform;

import java.util.ArrayList;
import java.util.List;

public class CountrySorter {

    /**
     * Generates a score based on which to sort the countries. Higher score is better.
     * @return
     */
    private static float calculateRankingScore(TravelForm form, Country country) {
        float score = 0.0f;
        for (Activity activity : form.chosenActivities) {
            if (country.activityRanking.containsKey(activity) && country.activityRanking.get(activity) != 0) {
                score += 1.0f/(float)country.activityRanking.get(activity);
            }
        }
        return score;
    }

    /**
     *
     * @param form
     * @param c1
     * @param c2
     * @return False if c1 should come first, true otherwise.
     */
    private static boolean compare(TravelForm form, Country c1, Country c2) {
        if (c1.climate == form.climate && c2.climate != form.climate) return false;
        if (c1.climate != form.climate && c2.climate == form.climate) return true;
        if (c1.climate != form.climate && c2.climate != form.climate) {
            if (c1.climate != c2.climate && form.climate != Climate.Mild) {
                if (c1.climate == Climate.Mild) return false;
                else return true;
            }
        }
        return calculateRankingScore(form, c1) < calculateRankingScore(form, c2);
    }

    /**
     * Sorts the countries based on the form parameters
     * @param form
     * @param countries
     * @return
     */
    public static List<Country> sort(TravelForm form, List<Country> countries) {
        List<Country> ret = new ArrayList<>(countries);
        for (int i = 0; i < countries.size(); i++) {
            int best = i;
            for (int j = i+1; j < countries.size(); j++) {
                if (compare(form, ret.get(i), ret.get(j))) {
                    best = j;
                }
            }
            Country temp = ret.get(i);
            ret.set(i, ret.get(best));
            ret.set(best, temp);
        }
        return ret;
    }
}
