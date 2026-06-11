package service;

import java.util.List;
import java.util.Optional;

import domain.Account;

public interface BankService {

    public void openAccount(String name, String email, String accountType,  Double initialBalance);

    public void deposit(String accNo, Double amount, String note);

    public List<Account> getAllAccounts();
    
}