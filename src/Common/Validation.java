package Common;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Country;

public class Validation {
    static final Scanner sc = new Scanner(System.in);
    
    public static String getString(String prompt){
        System.out.print(prompt);
        String s =sc.nextLine();
        while(s.isEmpty()){
            System.out.print("Enter again(Can not blank): ");
            s = sc.nextLine();
        }
        return s;
    }
    
   public static int getInt(String prompt){
    int i = 0;
    boolean isValid = false;
    while (isValid == false){
        System.out.print(prompt);
        if (sc.hasNextInt()){
            i = sc.nextInt();
            isValid = true;
    } 
    else{
        System.out.println("Error! Invalid integer value. Try again.");
    }
        sc.nextLine();
    }
        return i;
   }
   public static int getInt(String prompt,int min, int max){
       int i = 0;
       boolean isValid = false;
       while (isValid == false){
           i= getInt(prompt);
           if (i<min)
               System.out.println("Error! Number must be greater than " + min + ".");
           else if(i> max){
               System.out.println("Error! Number must be less than " + max + ".");
           }
           else 
               isValid = true;
       }
          return i;
    }

    public static double getDouble(String prompt){
        double d =0;
        boolean isValid = false;
        while (isValid==false){
            System.out.print(prompt);
            if(sc.hasNextDouble()){
                d = sc.nextDouble();
                isValid = true;
            }
            else{
                System.out.println("Error! Invalid decimal value.Try again");
            }
            sc.nextLine();
        }
        return d;
     }
    
    public static double getDouble(String prompt,double min,double max){
        double d = 0;
        boolean isValid = false;
        while (isValid == false){
            d= getDouble(prompt);
            if (d<min)
                System.out.println("Error! Number must be greater than " + min + ".");
            else if(d> max){
                System.out.println("Error! Number must be less than " + max + ".");
            }
            else 
                isValid = true;
        }
           return d;
     }
     public static String getCountryCode() {
        while (true) {
            String result = getString("Enter code of country: ");
            //check user input phone valid
            if (result.matches("^.{2,3}$")) {
                return result.toUpperCase();
            } else {
                System.err.println("Country code should have 3 characters");
            }
        }
    }

    public static boolean checkCountryCode(ArrayList<Country> countries,String countryCode){
        for(Country c : countries){
            if(c.getCountryCode().equalsIgnoreCase(countryCode)){
                return false;
            }
        }
        return true;
    }
}
