package com.company.travelform;

import java.util.HashSet;
import java.util.Set;

public class TravelForm {
	public String countryName;
	public float budget;
	public int numPeople;
	public Climate climate;
	public TravelMethod travelMethod;
	public Set<Activity> chosenActivities;

	public TravelForm() {
		budget = 0.0f;
		numPeople = 0;
		climate = Climate.Mild;
		travelMethod = TravelMethod.Airplane;
		chosenActivities = new HashSet<>();
	}
}
