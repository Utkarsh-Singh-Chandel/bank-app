package service.impl;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.security.auth.login.AccountNotFoundException;

import domain.Account;
import domain.Customer;
import domain.Transaction;
import domain.Type;
import repository.AccountRepository;
import repository.CustomerRepository;
import repository.TransactionRepository;
import service.BankService;

public class BankServiceImpl implements BankService{

    // initialise all services and any object like repositories;
    private final CustomerRepository customerRepository = new CustomerRepository(); 
    
    private final AccountRepository accountRepository = new AccountRepository();

    private final TransactionRepository transactionRepository = new TransactionRepository();


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
    public void deposit(String accNo, Double amt, String note){
        Account account = accountRepository.findById(accNo).orElseThrow( () -> new exceptions.AccountNotFoundException("Account not found ! please try again. "));
        // to do ; validate amount and note

        // this is not atomic it can cause problem 

        account.incrementBalance(amt);

        String txnId = generateUniqueId();
        LocalDateTime now = LocalDateTime.now();
        Transaction txn = new Transaction(txnId, accNo, Type.DEPOSIT , amt, note, now);
        transactionRepository.save(txn);


    }

    @Override
    public List<Account> getAllAccounts(){
        // understand this code
       return  accountRepository.findAll()
                .stream()
                .sorted(Comparator.comparing(Account::getId))
                .collect(Collectors.toList());

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
