package repository;

import java.util.HashMap;
import java.util.Map;

import domain.Account;

public class AccountRepository {
    
    private final Map<String, Account> accountsById = new HashMap<>();


    public void save(Account acc){

        System.out.println("Saving account details with id : " + acc.getId());
        accountsById.put(acc.getId(), acc);
        
    }

    public Account getDetails(String id){
        return accountsById.get(id);

    }
}
