package com.spring.spring_boot.service;

import com.spring.spring_boot.dao.UserRepository;
import com.spring.spring_boot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(Integer.valueOf(id));
    }

    @Override
    public User getUser(int id) {
        User user = null;
        Optional<User> userOptional = userRepository.findById(Integer.valueOf(id));
        if (userOptional.isPresent()) {
            user = userOptional.get();
        }
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
