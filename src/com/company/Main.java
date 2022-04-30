package com.company;

import com.company.travelform.Country;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    // write your code here
        var x = Country.loadFromFile("data/test.txt");
        System.out.println(x.toString());
    }
}
