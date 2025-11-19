package com.example.fake_wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fake_wallet.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Long>{

}
