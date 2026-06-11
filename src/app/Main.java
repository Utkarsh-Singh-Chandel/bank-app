
package app;

import java.util.List;
import java.util.Scanner;

import domain.Account;
import service.BankService;
import service.impl.BankServiceImpl;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // why is bank service here and not outside main function 
        BankService bankService = new BankServiceImpl();
        boolean run = true;
        while (run) {

            System.out.println(
                    """
                                Hello ! Please select an option below
                                1) Open account
                                2) Deposit 
                                3) Withdraw
                                4) Tranfer
                                5) List Accounts
                                6) Account statement
                                7) Search account by customer name
                                8) exit  


                            """);

            String option = scn.nextLine().trim();

            switch (option) {
                case "1":
                    // System.out.println("Name: " + name);
                    openAccount(scn, bankService);
                    break;

                case "2":
                    deposit(scn, bankService);
                    break;
                    

                case "3":
                    // withdraw(scn, bankService);

                case "4":
                    // transfer(scn, bankService);
                case "5":
                    listAccounts(bankService);
                    break;

                case "6":
                    // withdraw(scn, bankService);

                case "7":
                    System.out.println("Thank You for being a customer !");
                    run = false;
                    break;

                case "8":
                    System.out.println("Thank You for being a customer !");
                    run = false;
                    break;

                case "9":
                    listAccounts(bankService);
                    break;

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

        // System.out.println(bankService.getDetails(accId).printDetails());

    }

    
    private static void deposit(Scanner scn, BankService bankService){
        System.out.println("Enter account number : ");
        String accNo = scn.nextLine().trim();
        System.out.println("Enter amount : ");
        Double amount = Double.valueOf(scn.nextLine().trim());

        System.out.println("Enter note (optional) : ");
        String note = scn.nextLine().trim() ;

        bankService.deposit(accNo, amount, note);

    }
    private static void testCode() {
        Account acc = new Account("1", "savings", (double) 100, "11");
        String s = acc.printDetails();
        System.out.println(s);

    }

    private static void listAccounts(BankService bankService){
        List<Account> accounts = bankService.getAllAccounts();
        accounts.forEach( (acc) -> System.out.println("Account id: " + acc.getId() + "  balance: " + acc.getBalance() ));
    }


}

