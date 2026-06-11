package repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import domain.Transaction;

public class TransactionRepository {
    private final Map<String, List<Transaction>> txByAccount = new HashMap<>();

    public void save(Transaction txn){
        List<Transaction> list = txByAccount.computeIfAbsent(txn.getAccountId(), k -> new ArrayList<>());
        list.add(txn);
        
    }

    
}
