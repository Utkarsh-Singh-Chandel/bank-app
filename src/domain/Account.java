package domain;

public class Account {

    private String id;
    private String accountType;
    private Double balance;
    private String customerId;



    public Account(String id, String accountType, Double balance, String customerId){
        this.id = id;
        this.accountType = accountType;
        this.balance = balance;
        this.customerId = customerId;

    }

    public String getId(){
        return this.id;

    }

    public String printDetails(){
        return "Account id: " + id + " balance: " + balance + " type: " + accountType;

    }

    public Double getBalance(){
        return this.balance;

    }

    public void incrementBalance(Double amt){
        this.balance += amt;

    }

}
