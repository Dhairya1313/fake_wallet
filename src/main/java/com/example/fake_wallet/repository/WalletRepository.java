package com.example.fake_wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fake_wallet.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet,Long>{
	
}
