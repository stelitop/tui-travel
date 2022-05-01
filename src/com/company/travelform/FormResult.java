package com.company.travelform;

import java.util.List;

public class FormResult {

    /**
     * The next recommended best option.
     */
    public FormResult nextSuggestion;
    public float estimatedCost;
    public String countryName;

    private FormResult() {
        this.nextSuggestion = null;
        this.estimatedCost = 0.0f;
    }

    public static FormResult create(TravelForm form, List<Country> countries) {
        FormResult result = new FormResult();
        var sorted = CountrySorter.sort(form, countries);
        FormResult cur = null;
        for (int i = 0; i < countries.size(); i++) {
            if (i == 0) {
                cur = createForCountry(form, countries.get(i));
                result = cur;
            } else {
                FormResult next = createForCountry(form, countries.get(i));
                cur.nextSuggestion = next;
                cur = next;
            }
        }

        return result;
    }

    public static FormResult createForCountry(TravelForm form, Country country) {
        FormResult result = new FormResult();
        result.estimatedCost += form.numDays*country.hotelCost;
        for (var act : form.chosenActivities) {
            if (country.costsPerActivity.containsKey(act)) {
                result.estimatedCost += form.numDays * country.costsPerActivity.get(act);
            }
        }
        result.countryName = country.name;
        return result;
    }
}
