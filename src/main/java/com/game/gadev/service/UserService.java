package com.game.gadev.service;

import com.game.gadev.model.User;
import com.game.gadev.reposotory.UserRepository;
import com.game.gadev.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getSingleUser(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(UserVO userVO) {
        if()

    }
}
