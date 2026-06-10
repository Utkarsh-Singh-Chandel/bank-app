package service.impl;

import java.util.UUID;

import domain.Account;
import domain.Customer;
import repository.AccountRepository;
import repository.CustomerRepository;
import service.BankService;

public class BankServiceImpl implements BankService{

    // initialise all services and any object like repositories;
    private final CustomerRepository customerRepository = new CustomerRepository(); 
    
    private final AccountRepository accountRepository = new AccountRepository();

    @Override
    public void openAccount(String name, String email, String accountType, Double initalBalance){
        // TO Do : validate the input fields
       
        String accountId = generateAccountId();

        String customerId = generateUniqueId();

        Customer customer = new Customer(customerId, name, email);

        customerRepository.save(customer);

        Account account = new Account(accountId, accountType, initalBalance, customerId);

        accountRepository.save(account);


    }

    @Override
    public Account getDetails(String id){
        return accountRepository.getDetails(id);

    }

    // private boolean 

    private String generateUniqueId(){
        String accountNumber = UUID.randomUUID().toString();
        return accountNumber;
    }
    private String generateAccountId(){
        String accountNumber = UUID.randomUUID().toString();
        return accountNumber;
    }
}
