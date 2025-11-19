package com.example.fake_wallet.entity;

import java.util.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Account {
    @Id
    private Long AccountId;
    private String Accountname;
    private Wallet wallet;
    private Long accountBalance;
    private List<Transaction> transactions = new ArrayList<>();
    
    public Account(String accountname, Long accountBalance) {
        super();
        Accountname = accountname;
        this.accountBalance = accountBalance;
    }

    public Long getAccountId() {
        return AccountId;
    }

    public void setAccountId(Long accountId) {
        AccountId = accountId;
    }

    public String getAccountname() {
        return Accountname;
    }

    public void setAccountname(String accountname) {
        Accountname = accountname;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setAccount(this);
    }
    
    
}

