
package app;

import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        
        boolean run = true;
        while(run){
            
            System.out.println("""
                Hello ! Please select an option below
                0) Open account
                1) exit
            """);

            Scanner scn = new Scanner(System.in);
            String option = scn.nextLine().trim();

            switch (option) {
                case "0":
                    String name, accountType, initialBalance;
                    System.out.println("Enter your Name: ");
                    name = scn.nextLine().trim();
                    System.out.println("Enter account type (Savings/ Current) :");
                    accountType = scn.nextLine().trim();
                    System.out.println("Enter initial balance");
                    initialBalance = scn.nextLine().trim();
                    System.out.println("Name: " +  name);

                    break;

                
                case "1":
                    run = false;
                    System.out.println("Thank You for being a customer !");
                default:
                    break;
            }
        }


    }

}

