package com.example.fake_wallet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fake_wallet.entity.User;

public interface UserRepository extends JpaRepository<User,Long>{
	
}
