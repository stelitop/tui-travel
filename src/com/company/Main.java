package com.company;

import com.company.TextMan;

public class Main {

    public static void main(String[] args) {
		System.out.println("Hello");
        TextMan.writeFile("src/com/company/airplane_logo.txt");
        TextMan.writeLine("Welcome to TUI-Travel!");
    }
}
