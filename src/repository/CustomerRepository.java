package repository;

import java.util.HashMap;
import java.util.Map;

import domain.Customer;

public class CustomerRepository {
    private final Map<String, Customer> customersById = new HashMap<>();

    public  void save(Customer c){
        customersById.put(c.getId(), c);

    }

}
