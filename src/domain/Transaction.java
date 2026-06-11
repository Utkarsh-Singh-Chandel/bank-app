package domain;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private String accountId;
    private Type type;
    private Double amount;
    private String note;
    private LocalDateTime timestamp;

    public Transaction(String id , String accountId, Type type , Double amount ,String note, LocalDateTime time){
        this.id = id;
        this.accountId = accountId;
        this.type = type;
        this.amount = amount;
        this.note = note;
        this.timestamp = time;

    }

    public String getAccountId(){
        return this.accountId;
    }



}
