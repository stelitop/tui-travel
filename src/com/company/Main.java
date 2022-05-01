package com.company;

import com.company.TextMan;
import com.company.travelform.Country;

import java.util.List;

public class Main {

    public static void main(String[] args) {
		System.out.println("Hello");
        Country.loadCountries();
        TextMan.writeFile("src/com/company/airplane_logo.txt");
        TextMan.writeLine("Welcome to TUI-Travel!");
        TextMan.writeLine("Type \"plan\" to receive advice on your vacation. Type \"help\" for available commands.");

        while (true) {
            String command = TextMan.readString("> ");

            if (command.equals("plan")) {
                TextMan.writeLine("Planning your vacation!");
                TextMan.writeLine("Available destinations (Europe): ");
                TextMan.writeLine("");
                TextMan.writeGrid(Country.countryList);

                while (true) {
                    String destination = TextMan.readString("Enter your destination: ");
                    if (Country.countryList.contains(destination)) {
                        break;
                    }
                    TextMan.writeLine("");
                    TextMan.writeLine("Did you mean:");
                    List<String> suggestions = TextMan.filterStrings(Country.countryList, destination);
                    TextMan.writeGrid(suggestions);

                }
            }

            if (command.equals("quit")) {
                TextMan.writeLine("Bye!");
                System.exit(0);
            }

            if (command.equals("help")) {
                TextMan.writeLine("Available commands:");
                TextMan.writeLine("help         Print help menu");
                TextMan.writeLine("quit         Quit tui-travel");
                TextMan.writeLine("plan         Plan vacation with interactive dialogue");
            }
        }
   }
}
