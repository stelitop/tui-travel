package com.company.travelform;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TravelForm {
	public String countryName;
	public float budget;
	public int numPeople;
	public int numDays;
	public Climate climate;
	public TravelMethod travelMethod;
	public Set<Activity> chosenActivities;

	public static final List<String> activities = List.of(
			"Visit Museums",
			"Go Shopping",
			"Visit Theaters",
			"Visit Monuments",
			"Go to the Beach",
			"Visit Zoos",
			"Go Clubbing",
			"Visit Art Galleries",
			"Beauty and Spa"
	);

	public TravelForm() {
		budget = 0.0f;
		numPeople = 0;
		numDays = 0;
		climate = Climate.Mild;
		travelMethod = TravelMethod.Airplane;
		chosenActivities = new HashSet<>();
	}
}
