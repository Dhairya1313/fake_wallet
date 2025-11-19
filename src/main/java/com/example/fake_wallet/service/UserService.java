 

package com.example.fake_wallet.service;

import com.example.fake_wallet.dto.CreateUserDTO;
import com.example.fake_wallet.dto.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(CreateUserDTO request);
    UserResponseDTO findById(Long Id);
}