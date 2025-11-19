package com.example.fake_wallet.entity;

import jakarta.persistence.*;

@Entity
public class Transaction {
    @Id
    private Long transactionId;
    private Account account;
    private Double amount;
    private String type;
    private Double balanceAfter;
    
    public Transaction(Double amount, String type, Double balanceAfter) {
        this.amount = amount;
        this.type = type;
        this.balanceAfter = balanceAfter;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getBalanceAfter() {
        return balanceAfter;
    }

    public void setBalanceAfter(Double balanceAfter) {
        this.balanceAfter = balanceAfter;
    }
    
    
}