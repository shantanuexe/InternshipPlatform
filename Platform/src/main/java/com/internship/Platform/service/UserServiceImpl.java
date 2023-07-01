package com.internship.Platform.service;

import org.springframework.stereotype.Service;

import com.internship.Platform.entity.User;
import com.internship.Platform.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
