package com.example.fake_wallet.entity;

import java.util.*;

import jakarta.persistence.*;
@Entity
public class Wallet {
	@Id
	private Long walletId;
	
	private User user;
	private List<Account> accounts = new ArrayList<>();
	
	
	
	public Wallet(User user) {
		this.user = user;
	}
	public Long getWalletId() {
		return walletId;
	}
	public void setWalletId(Long walletId) {
		this.walletId = walletId;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public List<Account> getAccount() {
		return accounts;
	}
	
	public void addAccount(Account account) {
		this.accounts.add(account);
		account.setWallet(this);
	}
	
	
}
