package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import domain.Account;

public class AccountRepository {
    
    private final Map<String, Account> accountsById = new HashMap<>();


    public void save(Account acc){

        System.out.println("Saving account details with id : " + acc.getId());
        accountsById.put(acc.getId(), acc);
        
    }

    public Optional<Account> findById(String id){
        return Optional.ofNullable(accountsById.get(id));

    }

    public List<Account> findAll(){
        return new ArrayList<>(accountsById.values()) ;
        // ques why not return directly 
        // ques 2 why not return list and why array list retruned 
        // ques3 what is the <> before some arraylist hash map 

    }
}
