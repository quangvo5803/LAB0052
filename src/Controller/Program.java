package Controller;

import java.util.ArrayList;
import java.util.Collections;

import Common.Validation;
import View.Menu;
import Model.Country;

public class Program extends Menu<String> {
    static String[] mainChoice = { "Input the information of 1 countries in East Asia",
            "Display the information of country you've just input",
            "Search the information of country by the user-entered name",
            "Display the information of countries sorted name in ascending order", "Exit" };
    ArrayList<Country> countries;

    public Program() {
        super("Countries Management System", mainChoice);
        countries = new ArrayList<>();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1: {
                inputNewCountry();
                break;
            }
            case 2: {
                printCountryJustInput();
                break;
            }
            case 3: {
                searchCountry();
                break;
            }
            case 4: {
                printCountrySorted();
                break;
            }
            case 5: {
                System.exit(0);
            }
        }
    }

    public void inputNewCountry() {
        System.out.println();
        String countryCode = Validation.getCountryCode();
        while (!Validation.checkCountryCode(countries, countryCode)) {
            System.out.println("Dupplicate country code !!! Enter again !!!");
            countryCode = Validation.getCountryCode();
        }
        String countryName = Validation.getString("Enter name of country: ");
        double totalArea = Validation.getDouble("Enter total area: ");
        String countryTerain = Validation.getString("Enter terrain of country: ");
        countries.add(new Country(countryCode, countryName, totalArea, countryTerain));
        System.out.println("========== Created success ==========");
        System.out.println();
    }

    public void printCountryJustInput(){
        System.out.println();
        if(countries.isEmpty()){
            System.out.println("List is empty");
            System.out.println();
            return;
        }
        System.out.println("========== Newest Country You Have Input ==========");
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area","Terrain");
        countries.get(countries.size()-1).display();
        System.out.println();

    }

    public void searchCountry(){
        System.out.println();
        String countrySearch = Validation.getString("Enter the name you want to search for: ");
        int count = 0;
        for (Country c : countries){
            if(c.getCountryName().equalsIgnoreCase(countrySearch)){
                System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area","Terrain");
                c.display();
                count++;
            }
        }
        if(count == 0){
            System.out.println("Not found");
        }
        System.out.println();
    }
    public void printCountrySorted() {
        System.out.println();
        Collections.sort(countries);
        System.out.printf("%-10s%-25s%-20s%-25s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country country : countries) {
            country.display();
        }
        System.out.println();
    }
}
