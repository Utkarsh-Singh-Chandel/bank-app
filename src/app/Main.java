
package app;

import java.util.Scanner;

import domain.Account;
import service.BankService;
import service.impl.BankServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();
        boolean run = true;
        while (run) {

            System.out.println(
                    """
                                Hello ! Please select an option below
                                0) Open account
                                1) exit
                                2) get account details by id

                            """);

            String option = scn.nextLine().trim();

            switch (option) {
                case "0":
                    // System.out.println("Name: " + name);
                    openAccount(scn, bankService);
                    break;

                case "1":
                    run = false;
                    System.out.println("Thank You for being a customer !");
                    break;
                    

                case "2":
                    getAccountDetails(scn, bankService);

                case "3":
                    testCode();

                default:
                    break;
            }
        }

    }

    private static void openAccount(Scanner scn, BankService bankService) {
        String name, email, accountType, initialBalance;
        System.out.println("Enter your Name: ");
        name = scn.nextLine().trim();
        System.out.println("Enter your E-Mail: ");
        email = scn.nextLine().trim();
        System.out.println("Enter account type (Savings/ Current) :");
        accountType = scn.nextLine().trim();
        System.out.println("Enter initial balance");
        initialBalance = scn.nextLine().trim();

        Double initialBal = Double.valueOf(initialBalance);

        bankService.openAccount(name, email, accountType, initialBal);

    }

    private static void getAccountDetails(Scanner scn, BankService bankService) {
        System.out.println("enter account id");
        String accId = scn.nextLine().trim();

        System.out.println(bankService.getDetails(accId).printDetails());

    }

    private static void testCode() {
        Account acc = new Account("1", "savings", (double) 100, "11");
        String s = acc.printDetails();
        System.out.println(s);

    }
}
