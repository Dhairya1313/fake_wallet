package com.example.fake_wallet.service.impl;

import com.example.fake_wallet.dto.CreateUserDTO;
import com.example.fake_wallet.dto.UserResponseDTO;
import com.example.fake_wallet.entity.User;
import com.example.fake_wallet.entity.Wallet;
import com.example.fake_wallet.repository.UserRepository;
import com.example.fake_wallet.repository.WalletRepository;
import com.example.fake_wallet.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepo;
    private final WalletRepository walletRepo;

    public UserServiceImpl(UserRepository userRepo, WalletRepository walletRepo) {
        this.userRepo = userRepo;
        this.walletRepo = walletRepo;
    }

    @Override
    public UserResponseDTO createUser(CreateUserDTO req) {
        if (req == null) {
            throw new IllegalArgumentException("request cannot be null");
        }

        String username = req.getUserName();
        String password = req.getPassword();

        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("username is required");
        }
        if (password == null) {
            throw new IllegalArgumentException("password is required");
        }

        if (userRepo.findByUserName(username).isPresent()) {
            throw new IllegalArgumentException("username already taken");
        }

        User user = new User();
        user.setUserName(username);
        user.setPassword(password); 

        Wallet wallet = new Wallet();
        wallet.setUser(user);
        user.setWallet(wallet);

        
        User saved = userRepo.save(user);

        Long walletId = saved.getWallet() == null ? null : saved.getWallet().getWalletId();
        return new UserResponseDTO(saved.getUserId(), saved.getUserName(), walletId);
    }

    @Override
    public UserResponseDTO findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        }

        User u = userRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("User not found"));
        Long walletId = u.getWallet() == null ? null : u.getWallet().getWalletId();
        return new UserResponseDTO(u.getUserId(), u.getUserName(), walletId);
    }
}
