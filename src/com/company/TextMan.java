package com.company;

import com.company.travelform.Country;

import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextMan {
	public static String readString(String __name) {
		System.out.print(__name);
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
		String field = "";
		try {
			field = buf.readLine();
		} catch (IOException e) {

		}
		return field.toLowerCase();
	}

	public static void writeFile(String __file) {
		try {
			File file = new File(__file);
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				String data = scanner.nextLine();
				System.out.println(data);
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}
	}

	public static void writeLine(String __text) {
		System.out.println(__text);
	}

	public static void write(String __text) {
		System.out.print(__text);
	}

	public static void writeGrid(List<String> __strings) {
		int counter = 0;
		while(counter < __strings.size()) {
			for (int x = 0; x < 10; x++) {
				if (counter >= __strings.size())
					break;
				String country = __strings.get(counter);
				TextMan.write(country + " ");
				counter++;
			}
			TextMan.writeLine("");
		}
		TextMan.writeLine("");
	}

	public static List<String> filterStrings(List<String> __strings, String __sub) {
		List<String> matches = new ArrayList<String>();
		for (int i = 0; i < __strings.size(); i++) {
			String name = (String) __strings.get(i);
			if (name.toLowerCase().startsWith(__sub.toLowerCase())) {
				matches.add(name);
			}
		}
		return matches;
	}
}
