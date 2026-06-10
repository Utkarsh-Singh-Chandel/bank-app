package service;

import domain.Account;

public interface BankService {

    public void openAccount(String name, String email, String accountType,  Double initialBalance);

    public Account getDetails(String id);
    
}