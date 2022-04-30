package com.company.travelform;

import java.util.HashSet;
import java.util.Set;

public class TravelForm {
	public float budget;
	public int numPeople;
	public Climate climate;
	public Set<Activity> chosenActivities;

	public TravelForm() {
		budget = 0.0f;
		numPeople = 0;
		climate = Climate.Mild;
		chosenActivities = new HashSet<>();
	}
}
