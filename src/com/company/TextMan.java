package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextMan {
	public static String readString(String __name) {
		return "";	
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
}
